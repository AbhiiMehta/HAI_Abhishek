
package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Objects;

public class ExtentReportManager {

    static ExtentReports extentReports;
    public static void initReports()
    {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
        }
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\abhishek.mehta\\Downloads\\CucumberFramework-master\\HAI_Abhishek\\ExtentReports");
        extentReports.attachReporter(spark);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Abhishek Report");
        spark.config().setReportName("Extent REprot");
        extentReports.setSystemInfo("Framework Name", "Framework Name");
        extentReports.setSystemInfo("Author", "Abhishek Mehta");
        System.out.println("Extent Reports is installed.");
    }

    public static void flushReports() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
            System.out.println("Reprts flushed");
        }
        ExtentTestManager.removeExtentTest();
    }

    public static void createTest(String testName)
    {
        ExtentTestManager.setExtentTest(extentReports.createTest(testName));
    }

    public static void removeTest(String testName)
    {
        extentReports.removeTest(testName);
    }

    public static void addScreenShot(Status status, String message) {
        try {
            if (DriverManager.getDriver() == null) {
                System.out.println("Driver is not initialized. Cannot capture screenshot.");
                return;
            }

            String base64Image = "data:image/png;base64,"
                    + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getExtentTest().log(status,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
            System.out.println("Screenshot Attached");

            // Optionally add file path screenshot
            // ExtentTestManager.getExtentTest().log(status,
            //         MediaEntityBuilder.createScreenCaptureFromPath(String.valueOf(CaptureHelpers.getScreenshot(message))).build());
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static void pass(Markup message) {
        ExtentTestManager.getExtentTest().pass(message);
    }

    public static void fail(Object message) {
        ExtentTestManager.getExtentTest().fail((String) message);
    }

    public static void fail(Markup message) {
        ExtentTestManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentTestManager.getExtentTest().skip(message);
    }

    public static void skip(Markup message) {
        ExtentTestManager.getExtentTest().skip(message);
    }

    public static void info(Markup message) {
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void info(String message) {
        addScreenShot(Status.INFO,"");
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void warning(String message) {
        ExtentTestManager.getExtentTest().log(Status.WARNING, message);
    }

    public static void pass(String message) {
        addScreenShot(Status.PASS, "");
        ExtentTestManager.getExtentTest().pass(message);    }

    public static void fail(String message) {
        addScreenShot(Status.FAIL, "");
        ExtentTestManager.getExtentTest().pass(message);    }




}
