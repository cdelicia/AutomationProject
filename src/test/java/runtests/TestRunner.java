package runtests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/index.html", "json:target/cucumber/report.json"},
        features = "src/test/resources/features",
        glue = {"definitions", "runtests"},
        tags = "@smoke"
)

public class TestRunner {
}
