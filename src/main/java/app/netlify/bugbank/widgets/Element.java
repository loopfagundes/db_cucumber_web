package app.netlify.bugbank.widgets;

import app.netlify.bugbank.Page;
import app.netlify.bugbank.dataset.FilesOperation;
import app.netlify.bugbank.dataset.StorageSpace;
import app.netlify.bugbank.drivers.DriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class Element {
    private WebDriver driver = null;
    private By by = null;
    private WebElement locator = null;
    private final WebDriverWait wait;

    public Element(String locator) throws IOException, ParseException {
        this.driver = DriverManager.getDriver();
        this.by = Page.selector(Page.getSelector(locator));
        this.locator = Page.getElement(locator);
        this.wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
    }

    public void click() throws Exception {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(this.by)).click();
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void jsClick() throws Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) this.driver;
            executor.executeScript("arguments[0].click();", this.locator);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void text(String text) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
            element.clear();
            element.sendKeys(text);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void assertEquals(String expected) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
            element.getText();
            Assert.assertEquals(element.getText(), expected);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    /* Deixo aqui varias os metodos de aqui somente
       para teste como são:
       - viewText ver a mensagem antes de AssertEquals.
       - testSet ver se funciona com flexivel.
     * Se for um dos metodos funcionado e deixar o metodo como padrão.
     * Quando terminar do projeto e tem que
       apagar aqui metodo!
     */
    public void viewText() throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
            System.out.println("Message: " + element.getText());
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void getData(String nameProp, String key) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOf(locator));
            String getProp = StorageSpace.getData(nameProp, key);
            element.clear();
            element.sendKeys(getProp);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void setData(String nameProp, String number, String digit) throws IOException {
        WebElement element = this.wait.until(ExpectedConditions.visibilityOf(locator));
        String[] separator = element.getText().split("-");
        String justNumber = separator[0].replaceAll("[^0-9]", "");
        String justDigit = separator[1].replaceAll("[^0-9]", "");
        FilesOperation.setProperty(nameProp, number, justNumber);
        FilesOperation.setProperty(nameProp, digit, justDigit);
    }
}