package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.dataset.StorageSpace;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class RegisterSecondUserSD {

    @Então("Preencho E-mail do segundo usuario no campo de {string}")
    public void to_fill_in_email_second_user(String locator) throws Exception {
        new Element(locator).text(StorageSpace.getData("dataUser_2", "email"));
    }
}