package org.apache.kerby.kerberos.kerb.server;

import org.junit.Test;

public class MitIssueTest extends LoginTestBase {

    protected boolean allowUdp() {
        return false;
    }

    @Test
    public void performMitIssueTest() throws Exception {
        loginClientUsingTicketCache();
        loginServiceUsingKeytab();
        Thread.sleep(3600 * 1000);
    }
}
