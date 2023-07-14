package runtests;

import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import source.TestEnvironmentConfig;
import static source.TestEnvironmentConfig.getDriver;

public class Hooks {
    @Before(order = 0)
    public void scenarioStart() {
        TestEnvironmentConfig.initialize();
        getDriver().manage().deleteAllCookies();
    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshotAfterFail");
        }
        TestEnvironmentConfig.tearDown();
    }
}
