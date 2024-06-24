package app.netlify.bugbank.stepdefs.custom;

import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class RegisterSD {

    @Então("Armazeno o {string}, dados {string}, {string} e {string}")
    public void variable_storage(String locator, String dados, String conta, String digito) throws IOException, ParseException {
        new Element(locator).setData(dados, conta, digito);
    }

    @Então("Clico no botão {string} com javascript")
    public void click_js(String locator) throws Exception {
        new Element(locator).jsClick();
    }
}