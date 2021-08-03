package com.kani.javaxcrypto.core;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CertUtils {
    private CertUtils() {
    }

    public static PrivateKey getPrivateKey() throws Exception {
        InputStream privateKeyResource = Thread.currentThread().getContextClassLoader().getResourceAsStream("private_key.der");
        byte[] keyBytes = privateKeyResource.readAllBytes();

        PKCS8EncodedKeySpec spec =
                new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(spec);
        return privateKey;
    }

    public static PublicKey getPublicKey()
            throws Exception {
        InputStream privateKeyResource = Thread.currentThread().getContextClassLoader().getResourceAsStream("public.pem");
        byte[] keyBytes = privateKeyResource.readAllBytes();
        String key = new String(keyBytes);

        String publicKeyPEM = key
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END PUBLIC KEY-----", "");

        byte[] decoded = Base64.getDecoder().decode(publicKeyPEM);

        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }


}
