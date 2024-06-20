package app.netlify.bugbank.data;

import app.netlify.bugbank.DataHolder;
import app.netlify.bugbank.Page;
import app.netlify.bugbank.drivers.DriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class StorageSpace {

    public static void ignoreTheLetters(String elemnent, String nameProp, String number, String digit) throws IOException, ParseException {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement webElement = Page.getElement(elemnent);
        String[] separator = wait.until(ExpectedConditions.elementToBeClickable(webElement)).getText().split("-");
        String justNumber = separator[0].replaceAll("[^0-9]", "");
        String justDigit = separator[1].replaceAll("[^0-9]", "");
        FilesOperation.setProperty(nameProp, number, justNumber);
        FilesOperation.setProperty(nameProp, digit, justDigit);
        System.out.println(Arrays.toString(separator));
        System.out.println(justNumber);
        System.out.println(justDigit);
    }
}