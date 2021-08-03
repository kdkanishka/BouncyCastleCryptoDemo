package activationkeys;

import activationkeys.keymodel.Token;
import com.kani.javaxcrypto.core.CertUtils;
import com.kani.javaxcrypto.core.RSACryptoUtil;

import java.security.PublicKey;

public class Verifier {
    public static void main(String[] args) throws Exception {
        String activationKey = "OTM2MDIxODAtYzYxOC00NzkxLTgwMzItMGE5ZmJmZWMwMmQxOzE2MjgwMDgwNzUzNzI7b3duZXJAYWNtZS5jb20=;xiKSO1XdGWsWcLAfRZlXA5jqUBfZdh6gzqF6J/HYOW/bqe2fdrl2/EB9wJAF8WDpNksPDOidJVArDidOOgsYfS0gD5ulh0lvC0+nPPtQNSZ+KkQ4k2zdEM3s3VWvbmeEMhl1r/U3TE4OyycNphGygzbxCKESXWZKQ8xEt5bszBG/NaM0KZDQlqZ2ow2j20352HPka3wbq/bHsAMsV+PyTxpQ0gqYSWSD6qubB2Bu125vMdU/9uDJYU2eXhjT/jDoesGh94dE5/9sTj/pnN0+AtKK+epejAhJDKGsZGxkJ5YfgtTtSE4QEy02kR3AHnncU0aP7g3rnSH+mERMCnj0KA==";
        String[] attr = activationKey.split(";");
        String tokenStr = attr[0];
        String signature = attr[1];

        Token token = Token.deserialize(tokenStr);
        PublicKey publicKey = CertUtils.getPublicKey();
        RSACryptoUtil rsaCryptoUtil = new RSACryptoUtil();
        boolean isValid = rsaCryptoUtil.verify(token.toString(), signature, publicKey);
        System.out.println("Is valid token : " + isValid);
        System.out.println(token);

    }
}
