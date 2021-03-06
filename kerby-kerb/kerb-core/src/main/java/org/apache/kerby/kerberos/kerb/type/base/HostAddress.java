/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.kerby.kerberos.kerb.type.base;

import java.net.InetAddress;
import java.util.Arrays;

import org.apache.kerby.asn1.Asn1FieldInfo;
import org.apache.kerby.asn1.EnumType;
import org.apache.kerby.asn1.ExplicitField;
import org.apache.kerby.asn1.type.Asn1Integer;
import org.apache.kerby.asn1.type.Asn1OctetString;
import org.apache.kerby.kerberos.kerb.type.KrbSequenceType;

/*
HostAddress     ::= SEQUENCE  {
        addr-type       [0] Int32,
        address         [1] OCTET STRING
}
 */
public class HostAddress extends KrbSequenceType {
    protected enum HostAddressField implements EnumType {
        ADDR_TYPE,
        ADDRESS;

        @Override
        public int getValue() {
            return ordinal();
        }

        @Override
        public String getName() {
            return name();
        }
    }

    static Asn1FieldInfo[] fieldInfos = new Asn1FieldInfo[] {
            new ExplicitField(HostAddressField.ADDR_TYPE, Asn1Integer.class),
            new ExplicitField(HostAddressField.ADDRESS, Asn1OctetString.class)
    };

    public HostAddress() {
        super(fieldInfos);
    }

    public HostAddress(InetAddress inetAddress) {
        this();

        setAddrType(HostAddrType.ADDRTYPE_INET);
        setAddress(inetAddress.getAddress());
    }

    public HostAddrType getAddrType() {
        Integer value = getFieldAsInteger(HostAddressField.ADDR_TYPE);
        return HostAddrType.fromValue(value);
    }

    public void setAddrType(HostAddrType addrType) {
        setField(HostAddressField.ADDR_TYPE, addrType);
    }

    public byte[] getAddress() {
        return getFieldAsOctets(HostAddressField.ADDRESS);
    }

    public void setAddress(byte[] address) {
        setFieldAsOctets(HostAddressField.ADDRESS, address);
    }

    public boolean equalsWith(InetAddress address) {
        if (address == null) {
            return false;
        }
        HostAddress that = new HostAddress(address);
        return that.equals(this);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        } else if (!(other instanceof HostAddress)) {
            return false;
        }

        HostAddress that = (HostAddress) other;
        if (getAddrType() == that.getAddrType()
                && Arrays.equals(getAddress(), that.getAddress())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = getAddrType().getValue();
        if (getAddress() != null) {
            result = 31 * result + Arrays.hashCode(getAddress());
        }

        return result;
    }
}
