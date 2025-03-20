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
        BrowserEnum browser;
        boolean isHeadless;

        try {
            browser = BrowserEnum.valueOf(System.getProperty("driver", "chrome").toUpperCase());
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(UNSUPPORTED_BROWSER);
        }

        String headless = System.getProperty("headless", "false").toLowerCase();
        if (headless.equals("true") || headless.equals("false")) {
            isHeadless = Boolean.parseBoolean(headless);
        } else {
            throw new IllegalArgumentException("The headless argument only receives true or false!");
        }

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = getChromeOptions(isHeadless);
                return new ChromeDriver(chromeOptions);

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = getFirefoxOptions(isHeadless);
                return new FirefoxDriver(firefoxOptions);

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
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
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

    private static FirefoxOptions getFirefoxOptions(boolean isHeadless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--ignored-certificates-errors");
        if (isHeadless) {
            firefoxOptions.addArguments("--headless");
        }
        return firefoxOptions;
    }

    private static EdgeOptions getEdgeOptions(boolean isHeadless) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-dev-shm-usage");
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