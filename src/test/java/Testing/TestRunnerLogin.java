package Testing;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
import pages.QuotePage;

@Test
@CucumberOptions(features= //{"src/main/resources/feat;urefiles/Login.feature",
        {   "src/main/resources/featurefiles/QuoteCreation.feature",
        "src/main/resources/featurefiles/AccManage.feature",
        "src/main/resources/featurefiles/Filter.feature"},

        glue = {"stepDefinitions","hooks"
        },
        plugin = {
                "pretty",
        },
        dryRun = false,
        monochrome = true
)


public class TestRunnerLogin extends AbstractTestNGCucumberTests {


}
