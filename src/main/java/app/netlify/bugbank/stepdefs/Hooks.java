package app.netlify.bugbank.stepdefs;

import app.netlify.bugbank.Page;
import app.netlify.bugbank.drivers.DriverFactory;
import app.netlify.bugbank.drivers.DriverManager;
import app.netlify.bugbank.utils.AppLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void beforeTest(Scenario scenario) {
        AppLogger.logInfo("BEFORE: THREAD ID : " + Thread.currentThread().getId() + ","
                + "SCENARIO NAME: " + scenario.getName());

        Page.setPage(scenario.getSourceTagNames());

        if (DriverManager.getDriver() == null) {
            DriverManager.setDriver(DriverFactory.createInstance());
        }
        if (ScenarioManager.getScenario() == null) {
            ScenarioManager.setScenario(scenario);
        }
    }

    @After
    public void afterTest(Scenario scenario) {
        AppLogger.logInfo("AFTER: THREAD ID : " + Thread.currentThread().getId() + ","
                + "SCENARIO NAME: " + scenario.getName());

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            ScenarioManager.getScenario().attach(screenshot, "image/png", ScenarioManager.getScenario().getName());
        }
    }
}