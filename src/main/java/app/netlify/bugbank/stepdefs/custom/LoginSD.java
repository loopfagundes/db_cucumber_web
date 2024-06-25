package app.netlify.bugbank.stepdefs.custom;

import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class LoginSD {

    @Então("Armazeno as informações do {string} e valido se {string}")
    public void data_storage(String dados, String locator) throws Exception {
        new Element(locator).setData(dados, locator);
    }

    @Então("Informo do {string} e preencho o {string} para fazer {string}")
    public void transfer_value(String dados, String valor, String locator) throws Exception {
        new Element(locator).fakeValue(dados, valor);
    }

    @Então("Valido se a {string}")
    public void transfer_completed_successfully(String locator) throws Exception {
        new Element(locator).assertEquals("Transferencia realizada com sucesso");
    }
}