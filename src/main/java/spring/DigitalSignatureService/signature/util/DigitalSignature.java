package spring.DigitalSignatureService.signature.util;

import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DigitalSignature {
    private static final Logger logger = LoggerFactory.getLogger(DigitalSignature.class);

    public static String sign(String secret,
                              String data) {
        byte[] secretBytes = secret.getBytes(StandardCharsets.UTF_8);
        byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
        byte[] hmacSHA256 = calculateHmacSHA256(secretBytes,
                dataBytes);

        if (hmacSHA256 == null) {
            return "";
        }

        return new String(Hex.encode(hmacSHA256));
    }

    private static byte[] calculateHmacSHA256(byte[] secret,
                                              byte[] data) {
        byte[] hmacSHA256 = null;

        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret,
                    "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSHA256 = mac.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            logger.error("Error", e);
        }

        return hmacSHA256;
    }
}
