# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "perl interface to libev, a high performance full-featured event loop."
HOMEPAGE = "https://metacpan.org/release/EV"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

DEPENDS = "libcanary-stability-perl-native libev"

SRC_URI = "https://cpan.metacpan.org/authors/id/M/ML/MLEHMANN/EV-${PV}.tar.gz"

SRC_URI[md5sum] = "33088705bc34bf66bccde50205c15e9f"
SRC_URI[sha256sum] = "d82190cf122fd5fa3bdb4d6f83d3221d0eb8024961e3db0a55fd867b63ccf594"

S = "${WORKDIR}/EV-${PV}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

RDEPENDS_${PN} = "libev"

BBCLASSEXTEND = "native"
