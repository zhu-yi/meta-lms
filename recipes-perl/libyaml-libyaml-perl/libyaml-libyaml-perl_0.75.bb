# SPD-License-Identifier: (Artistic-1.0 OR GPL-1.0-or-later)

SUMMARY = "Kirill Siminov's "libyaml" is arguably the best YAML implementation. The C \
library is written precisely to the YAML 1.1 specification. It was \
originally bound to Python and was later bound to Ruby."
HOMEPAGE= "https://metacpan.org/release/YAML-LibYAML"

LICENSE = "Artisticv1 | GPLv1+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SECTION = "libs"
PR = "r0"

SRC_URI = "https://cpan.metacpan.org/authors/id/T/TI/TINITA/YAML-LibYAML-${PV}.tar.gz"

SRC_URI[md5sum] = "83a2df6c2e6e5933074ef9f30a69e385"
SRC_URI[sha256sum] = "62ccd4a87daaf3576054f9027d9f3321116374a3a3882eb07166cf01b33792ca"

S = "${WORKDIR}/YAML-LibYAML-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
