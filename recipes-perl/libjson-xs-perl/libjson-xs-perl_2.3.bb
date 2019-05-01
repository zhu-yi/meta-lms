# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "This module converts Perl data structures to JSON and vice versa. Its \
           primary goal is to be *correct* and its secondary goal is to be *fast*. \
           To reach the latter goal it was written in C."
HOMEPAGE = "https://metacpan.org/release/JSON-XS"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

SRC_URI = "https://cpan.metacpan.org/authors/id/M/ML/MLEHMANN/JSON-XS-${PV}.tar.gz"

SRC_URI[md5sum] = "4dc2a968e41f8cf330d46be12f221a12"
SRC_URI[sha256sum] = "f697d2372d362be72168ef855c62803f5a5ceb6e43a3132da7e9d9f50e10fd02"

S = "${WORKDIR}/JSON-XS-${PV}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

BBCLASSEXTEND = "native"
