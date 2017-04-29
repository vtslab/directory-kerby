#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Run this file with the MitIssueTest.sh bash script
# Requires python 2.7.x with the kerberos package installed

import kerberos

result, context = kerberos.authGSSClientInit(
    service='test-service@localhost',
    principal='drankye@TEST.COM')
if context:
    print('kerberos.authGSSClientInit successful')
else:
    print('kerberos.authGSSClientInit not successful')

try:
    kerberos.authGSSClientStep(context, '')
    print('First kerberos.authGSSClientStep successful')
except Exception as e:
    print('First kerberos.authGSSClientStep not successful', e)
