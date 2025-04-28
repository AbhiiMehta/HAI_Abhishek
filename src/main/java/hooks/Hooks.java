package hooks;

import com.driver.DriverManager;
import com.driver.TargetFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;
import reports.ExtentReportManager;

public class Hooks {

    static WebDriver driver;
    @BeforeAll
    public static void before_All()
    {
        driver = ThreadGuard.protect(new TargetFactory().target("local","chrome"));
        DesiredCapabilities cap = new DesiredCapabilities();
    //    driver = ThreadGuard.protect(new TargetFactory().createRemoteInstance(cap));
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        cap.setCapability("OS","Windows");
        DriverManager.getDriver().get("https://qa.hai.rws.com/");//"https://uat.certified.hai.rws.com/en-US");
        ExtentReportManager.initReports();
        ExtentReportManager.createTest("Login");
    }

    @AfterAll
    public static void after_All()
    {
        ExtentReportManager.flushReports();
    //    driver.quit();
    }
}
