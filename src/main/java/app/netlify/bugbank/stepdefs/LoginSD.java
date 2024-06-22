package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.dataset.StorageSpace;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class LoginSD {

    @Então("Preencho Email no campo de {string}")
    public void email_login(String locator) throws Exception {
        new Element(locator).text(StorageSpace.getData("dataUser_1", "email"));
    }

    @Então("Preencho senha no campo de {string}")
    public void password_login(String locator) throws Exception {
        new Element(locator).text(StorageSpace.getData("dataUser_1", "password"));
    }

    @Então("Clico a botao {string}")
    public void access_login(String locator) throws Exception {
        new Element(locator).click();
    }

    @Então("Valido se {string} esta disponivel")
    public void balance_account(String locator) throws Exception {
        new Element(locator).assertEquals("Saldo em conta R$ 1.000,00");
    }

    @Então("Valido se {string} esta na tela de login")
    public void my_name_in_login(String locator) throws Exception {
        new Element(locator).assertEquals("Olá User_1,");
    }

    @Então("Preencho o {string}")
    public void numeber_account(String locator) throws Exception {
        new Element(locator).getData("dataUser_2","conta");
    }
}