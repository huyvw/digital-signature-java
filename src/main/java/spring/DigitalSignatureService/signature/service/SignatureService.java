package spring.DigitalSignatureService.signature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.DigitalSignatureService.signature.properties.SignatureProperties;
import spring.DigitalSignatureService.signature.request.ViewSignature;
import spring.DigitalSignatureService.signature.response.SignatureDetail;
import spring.DigitalSignatureService.signature.util.DigitalSignature;

@Service
public class SignatureService {

    private final SignatureProperties signatureProperties;

    public SignatureService(SignatureProperties signatureProperties){
        this.signatureProperties = signatureProperties;
    }
    public SignatureDetail view(ViewSignature request) {
        return new SignatureDetail(DigitalSignature.sign(signatureProperties.getSecretKey(), request.getData()));
    }
}
