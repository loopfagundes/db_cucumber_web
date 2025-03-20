package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.drivers.DriverManager;
import app.netlify.bugbank.dto.UserDataDTO;
import app.netlify.bugbank.dto.UserModelDTO;
import app.netlify.bugbank.widgets.Element;
import io.cucumber.java.pt.Então;

import static app.netlify.bugbank.utils.FilesOperation.*;

public class StepDefinitions {

    @Então("Navego para a {string} configurada")
    public void i_go_to(String url) {
        DriverManager.getDriver().get(loadProperties("configuration","config").getProperty(url));
        DriverManager.getDriver().manage().window().maximize();
    }

    @Então("Clico no botão {string}")
    public void i_click(String locator) throws Exception {
        new Element(locator).click();
    }

    @Então("Armazeno o nome do {string} e valido se {string}")
    public void data_name(String dados, String locator) throws Exception {
        new Element(locator).setName(dados, locator);
    }

    @Então("Armazeno o valor do {string} e valido se {string}")
    public void data_value(String dados, String locator) throws Exception {
        new Element(locator).setValue(dados, locator);
    }

    @Então("Encerro a sessão")
    public void close_session() {
        DriverManager.quit();
    }
}