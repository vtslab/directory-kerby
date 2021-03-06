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
package org.apache.kerby.x509.type;

import org.apache.kerby.asn1.Asn1FieldInfo;
import org.apache.kerby.asn1.EnumType;
import org.apache.kerby.asn1.type.Asn1BitString;
import org.apache.kerby.asn1.type.Asn1SequenceType;

import static org.apache.kerby.x509.type.AttributeCertificate.MyEnum.*;

/**
 * <pre>
 *  AttributeCertificate ::= SEQUENCE {
 *       acinfo               AttributeCertificateInfo,
 *       signatureAlgorithm   AlgorithmIdentifier,
 *       signatureValue       BIT STRING
 *  }
 * </pre>
 */
public class AttributeCertificate extends Asn1SequenceType {
    protected enum MyEnum implements EnumType {
        ACI_INFO,
        SIGNATURE_ALGORITHM,
        SIGNATURE_VALUE;
        
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
        new Asn1FieldInfo(ACI_INFO, AttributeCertificateInfo.class),
        new Asn1FieldInfo(SIGNATURE_ALGORITHM, AlgorithmIdentifier.class),
        new Asn1FieldInfo(SIGNATURE_VALUE, Asn1BitString.class)
    };

    public AttributeCertificate() {
        super(fieldInfos);
    }

    public AttributeCertificateInfo getAcinfo() {
        return getFieldAs(ACI_INFO, AttributeCertificateInfo.class);
    }

    public void setAciInfo(AttributeCertificateInfo aciInfo) {
        setFieldAs(ACI_INFO, aciInfo);
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return getFieldAs(SIGNATURE_ALGORITHM, AlgorithmIdentifier.class);
    }

    public void setSignatureAlgorithm(AlgorithmIdentifier signatureAlgorithm) {
        setFieldAs(SIGNATURE_ALGORITHM, signatureAlgorithm);
    }

    public Asn1BitString getSignatureValue() {
        return getFieldAs(SIGNATURE_VALUE, Asn1BitString.class);
    }

    public void setSignatureValue(Asn1BitString signatureValue) {
        setFieldAs(SIGNATURE_VALUE, signatureValue);
    }
}
