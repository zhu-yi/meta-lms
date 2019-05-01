# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "This module has only one function, which is also exported by default:"
HOMEPAGE= "https://metacpan.org/release/Sub-Name"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

SRC_URI = "https://cpan.metacpan.org/authors/id/F/FL/FLORA/Sub-Name-${PV}.tar.gz"

SRC_URI[md5sum] = "26077202597620e4a6068c8087f3e09f"
SRC_URI[sha256sum] = "c9d1b805ea1f8e35fdde319468d6378dc1f1123cd8f2b22788238ba842713af1"

S = "${WORKDIR}/Sub-Name-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
