package app.netlify.bugbank.widgets;

import app.netlify.bugbank.Page;
import app.netlify.bugbank.managers.PropertiesManager;
import app.netlify.bugbank.drivers.DriverManager;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class Element {
    private final WebDriver driver;
    private final By by;
    private final WebElement locator;
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

    public void assertEquals(String expected) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
            Assert.assertEquals(element.getText(), expected);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void getDataUser(String sendKeys) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOf(locator));
            element.clear();
            element.sendKeys(sendKeys);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void getData(String nameProp, String key) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOf(locator));
            String getProp = PropertiesManager.loadProperties("properties", nameProp).getProperty(key);
            element.clear();
            element.sendKeys(getProp);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void setName(String nameProp, String value) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOf(locator));
            String replacement = element.getText().replace("á", "a");
            PropertiesManager.setProperty("properties", nameProp, value, replacement);
            Assert.assertEquals(replacement, PropertiesManager.loadProperties("properties", nameProp).getProperty(value));
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void setValue(String nameProp, String value) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOf(locator));
            PropertiesManager.setProperty("properties", nameProp, value, element.getText());
            Assert.assertEquals(element.getText(), PropertiesManager.loadProperties("properties", nameProp).getProperty(value));
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void setAccountNumber(String nameProp, String number, String digit) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOf(locator));
            String[] separator = element.getText().split("-");
            String justNumber = separator[0].replaceAll("[^0-9]", "");
            String justDigit = separator[1].replaceAll("[^0-9]", "");
            PropertiesManager.setProperty("properties", nameProp, number, justNumber);
            PropertiesManager.setProperty("properties", nameProp, digit, justDigit);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public void fakeValue(String nameProp, String key) throws Exception {
        try {
            WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
            int fakeCash = Faker.instance().number().numberBetween(0, 999);
            int fakeCent = Faker.instance().number().numberBetween(0, 99);
            String fakeValue = fakeCash + "." + fakeCent;
            element.sendKeys(fakeValue);
            PropertiesManager.setProperty("properties", nameProp, key, fakeValue);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

}