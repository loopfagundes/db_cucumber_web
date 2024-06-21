package app.netlify.bugbank.widgets;

import app.netlify.bugbank.Page;
import app.netlify.bugbank.drivers.DriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void jsClick() throws Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor)this.driver;
            executor.executeScript("arguments[0].click();", this.locator);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void text(String text) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
            element.clear();
            element.sendKeys(text);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void getText() throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
            element.getText();
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            throw new Exception(e);
        }
    }
}