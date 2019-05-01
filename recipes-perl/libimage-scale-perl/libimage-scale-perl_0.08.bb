# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "Fast, high-quality fixed-point image resizing"
HOMEPAGE = "https://metacpan.org/release/Image-Scale"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

DEPENDS = "jpeg libpng"

SRC_URI = "https://cpan.metacpan.org/authors/id/A/AG/AGRUNDMA/Image-Scale-${PV}.tar.gz \
           file://0001-src-png.c-replace-png_memcpy-with-memcpy.patch;patch=1"

SRC_URI[md5sum] = "60d6b1d78e229682c3565ee12a171cb4"
SRC_URI[sha256sum] = "e2dcc90b9954a43dafc7f61bc6dc472382eb719b1046247da5a93cfdd7c3b3e0"

S = "${WORKDIR}/Image-Scale-${PV}"

inherit cpan

EXTRA_CPANFLAGS = "--with-jpeg-libs='${STAGING_LIBDIR}' --with-png-libs='${STAGING_LIBDIR}'"

do_configure_prepend() {
    export INCLUDE="${STAGING_INCDIR}"
}

do_configure_append_class-target() {
    sed -E \
        -e 's:-L${STAGING_LIBDIR}::g' \
        -e 's:-I${STAGING_INCDIR}::g' \
        -e 's:-L/usr/local/lib::g' \
        -i Makefile
}

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

RDEPENDS_${PN} = "jpeg libpng"

BBCLASSEXTEND = "native"
