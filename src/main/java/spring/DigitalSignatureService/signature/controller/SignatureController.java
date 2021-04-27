package spring.DigitalSignatureService.signature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.DigitalSignatureService.signature.request.ViewSignature;
import spring.DigitalSignatureService.signature.response.SignatureDetail;
import spring.DigitalSignatureService.signature.service.SignatureService;

import javax.validation.Valid;

@RestController
@RequestMapping("/signature")
public class SignatureController {

    private final SignatureService service;

    @Autowired
    public SignatureController(SignatureService service) {
        this.service = service;
    }

    @GetMapping
    public SignatureDetail view(@Valid ViewSignature request) {
        return service.view(request);
    }
}
