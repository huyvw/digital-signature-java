package spring.DigitalSignatureService.signature.response;

public class SignatureDetail {
    private final String signature;

    public SignatureDetail(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }
}
