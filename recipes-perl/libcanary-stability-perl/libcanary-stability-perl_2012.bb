# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "canary to check perl compatibility for schmorp's modules"
HOMEPAGE = "https://metacpan.org/release/Canary-Stability"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

SRC_URI = "https://cpan.metacpan.org/authors/id/M/ML/MLEHMANN/Canary-Stability-2012.tar.gz"

SRC_URI[md5sum] = "88516c29e3d7807a5943ce3a3bdcdb31"
SRC_URI[sha256sum] = "fd240b111d834dbae9630c59b42fae2145ca35addc1965ea311edf0d07817107"

S = "${WORKDIR}/Canary-Stability-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
