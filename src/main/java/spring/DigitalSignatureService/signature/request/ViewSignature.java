package spring.DigitalSignatureService.signature.request;

import javax.validation.constraints.NotNull;

public class ViewSignature {
    @NotNull(message = "Data can not null")
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
