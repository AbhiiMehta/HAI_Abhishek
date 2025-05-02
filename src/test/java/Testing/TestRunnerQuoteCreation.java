package Testing;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(features= //{"src/main/resources/feat;urefiles/Login.feature",
        "src/main/resources/featurefiles/QuoteCreation.feature",
        glue = {"stepDefinitions","hooks"
        },
        plugin = {
                "pretty",
        },
        dryRun = false,
        monochrome = true
)


public class TestRunnerQuoteCreation extends AbstractTestNGCucumberTests {


}
