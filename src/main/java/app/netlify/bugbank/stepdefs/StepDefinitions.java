package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.drivers.DriverManager;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class StepDefinitions {

    @Então("Navego para {string}")
    public void eu_vou_para(String url) {
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();
    }

    @Então("Clico no botão {string}")
    public void eu_clico(String locator) throws Exception {
        new Element(locator).click();
    }

    @Então("Preencho {string} no campo de texto {string}")
    public void eu_preencho(String text, String locator) throws Exception {
        new Element(locator).text(text);
    }

    @Então("Clico no botao {string}")
    public void eu_clico_js(String locator) throws Exception {
        new Element(locator).jsClick();
    }
}