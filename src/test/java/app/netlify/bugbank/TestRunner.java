package app.netlify.bugbank;

import app.netlify.bugbank.drivers.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "summary",
                "html:reports/report.html",
                "json:reports/report.json",
        },
        glue = { "app.netlify.bugbank.stepdefs" },
        features = "src/test/resources/features"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public static void tearDown() {
        DriverManager.quit();
    }
}