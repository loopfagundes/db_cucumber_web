package app.netlify.bugbank.dataset;

import app.netlify.bugbank.DataHolder;
import app.netlify.bugbank.Page;
import app.netlify.bugbank.drivers.DriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class StorageSpace {

    public static void ignoreTheLetters(String element, String nameProp, String number, String digit) throws IOException, ParseException {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement webElement = Page.getElement(element);
        String[] separator = wait.until(ExpectedConditions.visibilityOf(webElement)).getText().split("-");
        String justNumber = separator[0].replaceAll("[^0-9]", "");
        String justDigit = separator[1].replaceAll("[^0-9]", "");
        FilesOperation.setProperty(nameProp, number, justNumber);
        FilesOperation.setProperty(nameProp, digit, justDigit);
    }

    //testei com metodo data holder
    public static void dataHolder(String element, String variable) throws IOException, ParseException {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement webElement = Page.getElement(element);
        String[] separator = wait.until(ExpectedConditions.visibilityOf(webElement)).getText().split("-");
        String justNumber = separator[0].replaceAll("[^0-9]", "");
        String justDigit = separator[1].replaceAll("[^0-9]", "");
        String[] setNumberAccount = new String[]{justNumber, justDigit};
        DataHolder.put(variable, setNumberAccount);
    }

    public static String getData(String nameProp, String key) throws IOException {
        return FilesOperation.getProperties(nameProp).getProperty(key);
    }
}