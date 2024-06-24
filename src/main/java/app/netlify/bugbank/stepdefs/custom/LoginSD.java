package app.netlify.bugbank.stepdefs.custom;

import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class LoginSD {

    @Então("Valido se {string} esta disponivel")
    public void balance_account(String locator) throws Exception {
        new Element(locator).assertEquals("Saldo em conta R$ 1.000,00");
    }

    @Então("Valido se {string} esta na tela de login")
    public void my_name_in_login(String locator) throws Exception {
        new Element(locator).assertEquals("Olá User_1,");
    }
}