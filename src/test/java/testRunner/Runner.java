package testRunner;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Login.feature",
        glue = "stepdefinitions",
        dryRun = false,
        tags = "@Smoke",
        plugin = {"pretty","html:test-output.html"}
)

public class Runner extends AbstractTestNGCucumberTests {
}
