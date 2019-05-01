# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

DESCRIPTION = "This package contains the Parser.pm module with friends."
HOMEPAGE = "https://metacpan.org/release/HTML-Parser"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;md5=41c63ed3507c434404cf2d57c14960a6"

DEPENDS += "perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/HTML-Parser-${PV}.tar.gz"

SRC_URI[md5sum] = "5550b2da7aa94341f1e8a17a4ac20c68"
SRC_URI[sha256sum] = "430e852cd4e6c5f178e7d60f05fc17419de7cf3192d5ed75df01c47d318e16c2"

S = "${WORKDIR}/HTML-Parser-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
BBCLASSEXTEND = "native"
