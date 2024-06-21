package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.dataset.StorageSpace;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class RegisterUserSD {

    @Então("Preencho E-mail do usuario no campo de {string}")
    public void to_fill_in_email(String locator) throws Exception {
        new Element(locator).text(StorageSpace.getData("dataUser_1", "email"));
    }

    @Então("Preencho o nome do usuario no campo de {string}")
    public void to_fill_in_name(String locator) throws Exception {
        new Element(locator).text(StorageSpace.getData("dataUser_1", "name"));
    }

    @Então("Preencho a senha do usuario no campo de {string}")
    @Então("Preencho a senha novamente do usuario no campo {string}")
    public void to_fill_in_password(String locator) throws Exception {
        new Element(locator).text(StorageSpace.getData("dataUser_1", "password"));
    }

    @Então("Armazeno o numero da conta do usuario")
    public void variable_storage() throws IOException, ParseException {
        StorageSpace.ignoreTheLetters("id:modalText", "dataUser_1", "numberAccount", "digit");
        //StorageSpace.dataHolder("id:modalText", "getData");
    }
}