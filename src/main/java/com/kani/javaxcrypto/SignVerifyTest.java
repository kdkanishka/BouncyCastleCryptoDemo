package com.kani.javaxcrypto;

import com.kani.javaxcrypto.core.CertUtils;
import com.kani.javaxcrypto.core.RSACryptoUtil;

import java.security.PrivateKey;
import java.security.PublicKey;

public class SignVerifyTest {
    public static void main(String[] args) throws Exception {
        RSACryptoUtil rsaCryptoUtil = new RSACryptoUtil();

        String textToSign = "Text to be signed";

        PrivateKey privateKey = CertUtils.getPrivateKey();
        //sign
        String signature = rsaCryptoUtil.sign(textToSign, privateKey);
        System.out.println("Signature");
        System.out.println(signature);

        //verify
        PublicKey publicKey = CertUtils.getPublicKey();
        boolean isVerified = rsaCryptoUtil.verify(textToSign, signature, publicKey);
        System.out.println("Is verified : " + isVerified);

    }
}
