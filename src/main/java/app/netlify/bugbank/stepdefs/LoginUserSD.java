package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.dataset.StorageSpace;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class LoginUserSD {

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
        new Element(locator).jsClick();
    }
}