# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "Fast, flexible and highly extensible template processing system."
HOMEPAGE = "https://metacpan.org/release/Template-Toolkit"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

SRC_URI = "https://cpan.metacpan.org/authors/id/A/AB/ABW/Template-Toolkit-${PV}.tar.gz"

SRC_URI[md5sum] = "0708d159250e760b6e82294211ad1dc1"
SRC_URI[sha256sum] = "9057c6b31db96895326d8ac17e5ebaa26ca661f5132bba2acc7c38a3df61e1ab"

S = "${WORKDIR}/Template-Toolkit-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
