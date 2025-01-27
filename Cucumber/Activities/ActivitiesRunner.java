package testRunner;

import org.junit.runner.RunWith;
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
/*@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@activity5"
)*/
/*@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"pretty"},
        monochrome = true
)*/
/*@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"html: test-reports"},
        monochrome = true
)*/
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"pretty"},
        monochrome = true
)

public class ActivitiesRunner {
        //This is intentionally blank
}