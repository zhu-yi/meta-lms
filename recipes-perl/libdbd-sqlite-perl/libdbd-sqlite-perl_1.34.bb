# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "A Perl DBI driver for SQLite"
DESCRIPTION = "DBD::SQLite is a Perl DBI driver for SQLite, that includes the entire \
thing in the distribution. So in order to get a fast transaction capable \
RDBMS working for your perl project you simply have to install this \
module, and nothing else. \
"
HOMEPAGE = "https://metacpan.org/pod/DBD::SQLite"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
DEPENDS += "libdbi-perl-native"
RDEPENDS_${PN} += "libdbi-perl \
                   sqlite3 \
                   perl-module-constant \
                   perl-module-locale \
                   perl-module-tie-hash \
"

LIC_FILES_CHKSUM = "file://LICENSE;md5=385c55653886acac3821999a3ccd17b3"

SRC_URI = "https://cpan.metacpan.org/authors/id/A/AD/ADAMK/DBD-SQLite-${PV}_01.tar.gz \
           file://sqlite-perl-test.pl \
"

SRC_URI[md5sum] = "2583ad592bfc9ea443860c12c303b6b8"
SRC_URI[sha256sum] = "21e5ceced5fce0143b0035ac8d2cfb152e5b1ed1d426438ec47dac30ea5f36dc"

UPSTREAM_CHECK_REGEX = "DBD\-SQLite\-(?P<pver>(\d+\.\d+))(?!_\d+).tar"

S = "${WORKDIR}/DBD-SQLite-${PV}_01"

inherit cpan

BBCLASSEXTEND = "native"

do_install_append() {
    if [ ${PERL_DBM_TEST} = "1" ]; then
        install -m 755 -D ${WORKDIR}/sqlite-perl-test.pl ${D}/${bindir}/sqlite-perl-test.pl
    fi
}

