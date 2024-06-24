package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.drivers.DriverManager;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

public class StepDefinitions {

    @Então("Navego para {string}")
    public void i_go_to(String url) {
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();
    }

    @Então("Preencho o campo {string} do usuário {string}")
    public void i_fill_in(String locator, String dados) throws Exception {
        new Element(locator).getData(dados, locator);
    }

    @Então("Clico no botão {string}")
    public void i_click(String locator) throws Exception {
        new Element(locator).click();
    }

    @Então("Encerro a sessão")
    public void close_session() {
        DriverManager.quit();
    }
}