package activationkeys;

import activationkeys.keymodel.Token;
import com.kani.javaxcrypto.core.CertUtils;
import com.kani.javaxcrypto.core.RSACryptoUtil;

import java.security.PrivateKey;
import java.util.UUID;

public class KeyGen {
    public static void main(String[] args) throws Exception {
        Token token = new Token(UUID.randomUUID().toString(),System.currentTimeMillis(),"owner@acme.com");
        System.out.println(token);

        PrivateKey privateKey = CertUtils.getPrivateKey();
        RSACryptoUtil rsaCryptoUtil = new RSACryptoUtil();
        String signature = rsaCryptoUtil.sign(token.toString(), privateKey);

        System.out.println(signature);
        String distributableToken = token.serialize()+";"+signature;

        System.out.println("Key");
        System.out.println(distributableToken);
    }
}
