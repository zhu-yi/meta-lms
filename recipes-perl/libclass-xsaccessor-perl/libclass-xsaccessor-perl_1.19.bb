# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "Generate fast XS accessors without runtime compilation"
HOMEPAGE= "https://metacpan.org/release/Class-XSAccessor"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

SRC_URI = "https://cpan.metacpan.org/authors/id/S/SM/SMUELLER/Class-XSAccessor-${PV}.tar.gz"

SRC_URI[md5sum] = "5c5dea74f00ad37c5119dd22b28a5563"
SRC_URI[sha256sum] = "99c56b395f1239af19901f2feeb125d9ecb4e351a0d80daa9529211a4700a6f2"

S = "${WORKDIR}/Class-XSAccessor-${PV}"

inherit cpan

#do_configure_append() {
# nasty way to get around build error
#    sed -e 's:-Werror=format-security::g' -i Makefile
#}

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
