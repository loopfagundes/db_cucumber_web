package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.dataset.StorageSpace;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class RegisterSD {

    @Então("Preencho o meu E-mail no campo de {string}")
    public void to_fill_in_email(String locator) throws Exception {
        new Element(locator).getData("dataUser_1", "email");
    }

    @Então("Preencho o meu nome no campo de {string}")
    public void to_fill_in_name(String locator) throws Exception {
        new Element(locator).getData("dataUser_1", "name");
    }

    @Então("Preencho a minha senha no campo de {string}")
    @Então("Preencho a minha senha novamente no campo {string}")
    public void to_fill_in_password(String locator) throws Exception {
        new Element(locator).getData("dataUser_1", "password");
    }

    @Então("Armazeno o Numero da conta")
    public void variable_storage() throws IOException, ParseException {
        StorageSpace.ignoreTheLetters("id:modalText", "dataUser_1", "numberAccount", "digit");
        //new Element(locator).setData("dataUser_1", "numberAccount", "digit");
    }

    @Então("Preencho o {string} no campo de email")
    public void to_fill_in_email2(String locator) throws Exception {
        new Element(locator).getData("dataUser_2", "email");
    }

    @Então("Preencho o {string} no campo de nome")
    public void to_fill_in_name2(String locator) throws Exception {
        new Element(locator).getData("dataUser_2", "name");
    }

    @Então("Preencho a {string} no campo")
    @Então("Preencho a {string} novamente no campo")
    public void to_fill_in_password2(String locator) throws Exception {
        new Element(locator).getData("dataUser_2", "password");
    }

    @Então("Clico no botao {string}")
    public void click_js(String locator) throws Exception {
        new Element(locator).jsClick();
    }

    @Então("Armazeno o numero da conta do usuario")
    public void variable_storage2() throws IOException, ParseException {
        StorageSpace.ignoreTheLetters("id:modalText", "dataUser_2", "conta", "digita");
    }
}