package app.netlify.bugbank.stepdefs.custom;

import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class LoginSD {

    @Então("Informo do {string} e preencho o {string} no campo {string}")
    public void transfer_value(String dados, String valor, String locator) throws Exception {
        new Element(locator).fakeValue(dados, valor);
    }

    @Então("Valido se a {string}")
    public void transfer_completed_successfully(String locator) throws Exception {
        new Element(locator).assertEquals("Transferencia realizada com sucesso");
    }
}