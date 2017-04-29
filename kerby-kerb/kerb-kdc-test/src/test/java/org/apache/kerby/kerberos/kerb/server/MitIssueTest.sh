#!/usr/bin/env bash

# First start Directory-Kerby with
# $ export KRB5_TRACE=/dev/stdout
# $ mvn clean test -Dtest=MitIssueTest

# Then, run this bash script from the Apache Directory-Kerby project root, with
# $ . kerby-kerb/kerb-kdc-test/src/test/java/org/apache/kerby/kerberos/kerb/server/MitIssueTest.sh

WORKDIR=kerby-kerb/kerb-kdc-test/target/tmp

export KRB5_CONFIG=$WORKDIR/krb5.conf
export KRB5CCNAME=$WORKDIR/test-tkt.cc
export KRB5_TRACE=/dev/stdout

python kerby-kerb/kerb-kdc-test/src/test/java/org/apache/kerby/kerberos/kerb/server/MitIssueTest.py
