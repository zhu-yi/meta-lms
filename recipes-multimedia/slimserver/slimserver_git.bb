# SPD-License-Identifier: GPL-2.0-only

SUMMARY = "Server for Logitech Squeezebox players, a.k.a. Logitech Media Server"
HOMEPAGE = "http://mysqueezebox.com"
SECTION = "console/utils"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://server/License.txt;md5=1c5138338dfe20ec44c8ac5a37d8dd00"

DEPENDS = "rsync-native"

SRCREV_server = "${AUTOREV}"
SRCREV_platforms = "${AUTOREV}"
SRCBRANCH = "public/7.9"

SRC_URI ="git://github.com/Logitech/${PN}.git;protocol=git;branch=${SRCBRANCH};name=server;destsuffix=git/server \
          git://github.com/Logitech/${PN}-platforms.git;protocol=git;branch=${SRCBRANCH};name=platforms;destsuffix=git/platforms \
          file://${PN}.service \
"

S = "${WORKDIR}/git"

inherit useradd systemd

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --home-dir ${libdir}/${PN} --user-group lms"

do_install() {
    ${S}/platforms/buildme.pl --build tarball --buildDir ${WORKDIR}/tmp --sourceDir ${S} --destDir ${WORKDIR} --destName ${PN} --noCPAN

    install -d ${D}${libdir}
    tar -C ${D}${libdir} -xzf ${WORKDIR}/${PN}-noCPAN.tgz
    mv ${D}${libdir}/${PN}-noCPAN ${D}${libdir}/${PN}

    # remove self-contained module as their version are too old to compile
    rm -r ${D}${libdir}/${PN}/CPAN/Class/XSAccessor*
    rm -r ${D}${libdir}/${PN}/CPAN/YAML

    # create directories for LMS runtime use
    install -m 0755 -d ${D}${libdir}/${PN}/prefs
    install -m 0755 -d ${D}${libdir}/${PN}/log
    install -m 0755 -d ${D}${libdir}/${PN}/cache

    chown -R lms:lms ${D}${libdir}/${PN}

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_system_unitdir}/${PN}.service
}

FILES_${PN} += " \
    ${libdir}/${PN}/* \
    ${systemd_system_unitdir}/${PN}.service \
"

SYSTEMD_SERVICE_${PN} = "${PN}.service"

# slimserver seems quite picky at the perl module versions, some packages
# support newer version while some not, so explicit specify the version for now
RDEPENDS_${PN} += " \
    perl \
    perl-modules \
    libaudio-scan-perl (=0.99) \
    libclass-xsaccessor-perl (=1.19) \
    libdbd-sqlite-perl (=1.34) \
    libdbi-perl (=1.616) \
    libdigest-sha1-perl \
    libev-perl (=4.03) \
    libhtml-parser-perl (=3.68) \
    libimage-scale-perl (=0.08) \
    libio-socket-ssl-perl \
    libjson-xs-perl (=2.3) \
    libsub-name-perl (=0.05) \
    libtemplate-toolkit-perl (=2.21) \
    libxml-parser-perl (=2.41) \
    libyaml-libyaml-perl (=0.75) \
"
