package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.data.FilesOperation;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class CustomSD {
    @Então("Preencho E-mail do usuario no campo de {string}")
    public void to_fill_in_email(String locator) throws Exception {
        String email = FilesOperation.getProperties("dataUser_1").getProperty("email"); //deve ser flexivel + 1 classe
        new Element(locator).text(email);
    }

    @Então("Preencho o nome do usuario no campo de {string}")
    public void to_fill_in_name(String locator) throws Exception {
        String name = FilesOperation.getProperties("dataUser_1").getProperty("name");
        new Element(locator).text(name);
    }

    @Então("Preencho a senha do usuario no campo de {string}")
    public void to_fill_in_password(String locator) throws Exception {
        String password = FilesOperation.getProperties("dataUser_1").getProperty("password");
        new Element(locator).text(password);
    }
}