package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.drivers.DriverManager;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

import java.io.IOException;

import static app.netlify.bugbank.utils.FilesOperation.*;

public class StepDefinitions {

    @Então("Navego para a {string} configurada")
    public void i_go_to(String url) throws IOException {
        DriverManager.getDriver().get(getProperties("config").getProperty(url));
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

    @Então("Armazeno as informações do {string} e valido se {string}")
    public void data_storage(String dados, String locator) throws Exception {
        new Element(locator).setData(dados, locator);
    }

    @Então("Encerro a sessão")
    public void close_session() {
        DriverManager.quit();
    }
}