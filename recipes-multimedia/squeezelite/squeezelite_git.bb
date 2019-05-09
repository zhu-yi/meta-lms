# SPD-License-Identifier: GPL-3.0-only

SUMMARY = "Lightweight headless squeezebox player for Logitech Media Server"
HOMEPAGE = "https://github.com/ralph-irving/squeezelite/"
SECTION = "console/utils"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4a6efe45e946fda532470a3da05195c3"

DEPENDS = " \
    alsa-lib \
    flac \
    libmad \
    libvorbis \
    mpg123 \
    faad2 \
    libav \
    soxr \
    wiringpi\
"

SRCREV = "09672cfea0b45a0fee635ed62ee788e6ece3c858"

SRC_URI = "git://github.com/ralph-irving/${PN}.git;protocol=git;branch=master \
           file://${PN}.service"

S = "${WORKDIR}/git"

inherit systemd

EXTRA_OEMAKE = 'OPTS="-DRESAMPLE -DFFMPEG -DVISEXPORT -DDSD -DGPIO -DRPI"'

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/${PN} ${D}${bindir}/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_system_unitdir}/${PN}.service
}

FILES_${PN} = " \
    ${bindir}/squeezelite \
    ${systemd_system_unitdir}/${PN}.service \
"

SYSTEMD_SERVICE_${PN} = "${PN}.service"

RDEPENDS_${PN} += " \
    flac \
    libmad \
    libvorbis \
    faad2 \
    libavcodec \
    libavformat \
"
