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

import org.apache.kerby.asn1.Asn1FieldInfo;
import org.apache.kerby.asn1.EnumType;
import org.apache.kerby.kerberos.kerb.KrbConstant;
import org.apache.kerby.kerberos.kerb.type.KrbAppSequenceType;

public abstract class KrbMessage extends KrbAppSequenceType {
    protected enum KrbMessageField implements EnumType {
        PVNO,
        MSG_TYPE;

        @Override
        public int getValue() {
            return ordinal();
        }

        @Override
        public String getName() {
            return name();
        }
    }

    private final int pvno = KrbConstant.KRB_V5;

    public KrbMessage(KrbMessageType msgType, Asn1FieldInfo[] fieldInfos) {
        super(msgType.getValue(), fieldInfos);
        setPvno(pvno);
        setMsgType(msgType);
    }

    public int getPvno() {
        return pvno;
    }

    protected void setPvno(int pvno) {
        setFieldAsInt(KrbMessageField.PVNO, pvno);
    }

    public KrbMessageType getMsgType() {
        Integer value = getFieldAsInteger(KrbMessageField.MSG_TYPE);
        return KrbMessageType.fromValue(value);
    }

    public void setMsgType(KrbMessageType msgType) {
        setFieldAsInt(KrbMessageField.MSG_TYPE, msgType.getValue());
    }
}
