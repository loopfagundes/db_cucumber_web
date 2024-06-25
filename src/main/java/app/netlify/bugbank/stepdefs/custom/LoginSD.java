package app.netlify.bugbank.stepdefs.custom;

import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginSD {

    @Então("Valido se {string} esta na tela de login")
    public void my_name_in_login(String locator) throws Exception {
        new Element(locator).assertEquals("Olá User_1,");
    }

    @Então("Valido se {string} esta disponivel")
    public void balance_account(String locator) throws Exception {
        new Element(locator).assertEquals("Saldo em conta R$ 1.000,00");
    }

    @Então("Informo do {string} e preencho o {string} para fazer {string}")
    public void transfer_value(String dados, String valor, String locator) throws Exception {
        new Element(locator).fakeValue(dados, valor);
    }

    @Então("Preencho informar uma {string} no campo")
    public void description(String locator) throws Exception {
        new Element(locator).text("test");
    }
}