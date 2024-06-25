package app.netlify.bugbank.stepdefs.custom;

import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class LoginSD {

    @Então("Valido se {string} esta na tela de login")
    public void my_name_in_login(String locator) throws Exception {
        new Element(locator).assertEquals("Olá User_1,");
    }

    @Então("Armazeno as informações do saldo do {string} e valido se {string}")
    public void validate_the_balance(String dados, String locator) throws Exception {
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