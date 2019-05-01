# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "Fast C metadata and tag reader for all common audio file formats"
HOMEPAGE = "https://metacpan.org/release/Audio-Scan"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

SRC_URI = "https://cpan.metacpan.org/authors/id/A/AG/AGRUNDMA/Audio-Scan-${PV}.tar.gz"

SRC_URI[md5sum] = "954e09d602616eaba95def63ab5feb3d"
SRC_URI[sha256sum] = "aad64aa1e4f4abd964e9d00fc5edc79f45f2231ed595b1520057272425130900"

S = "${WORKDIR}/Audio-Scan-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
