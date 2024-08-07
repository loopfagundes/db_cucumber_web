package app.netlify.bugbank.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    public static WebDriver createInstance() {
        String UNSUPPORTED_BROWSER = "The chosen browser is not supported!";
        Driver driver;
        boolean isHeadless;

        try {
            driver = Driver.valueOf(System.getProperty("driver", "chrome").toUpperCase());
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(UNSUPPORTED_BROWSER);
        }

        String headless = System.getProperty("headless", "false").toLowerCase();
        if (headless.equals("true") || headless.equals("false")) {
            isHeadless = Boolean.parseBoolean(headless);
        } else {
            throw new IllegalArgumentException("The headless argument only receives true or false!");
        }

        switch (driver) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = getChromeOptions(isHeadless);
                return new ChromeDriver(chromeOptions);

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return getFirefoxOptions(isHeadless);

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = getEdgeOptions(isHeadless);
                return new EdgeDriver(edgeOptions);
            default:
                throw new IllegalArgumentException(UNSUPPORTED_BROWSER);
        }
    }

    private static ChromeOptions getChromeOptions(boolean isHeadless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--ignored-certificates-errors");
        if (isHeadless) {
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
    }

    private static FirefoxDriver getFirefoxOptions(boolean isHeadless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (isHeadless) {
            firefoxOptions.addArguments("--headless");
        }
        return new FirefoxDriver(firefoxOptions);
    }

    private static EdgeOptions getEdgeOptions(boolean isHeadless) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--remote-allow-origins=*");
        edgeOptions.addArguments("--ignored-certificates-errors");
        if (isHeadless) {
            edgeOptions.addArguments("--headless");
        }
        return edgeOptions;
    }
}