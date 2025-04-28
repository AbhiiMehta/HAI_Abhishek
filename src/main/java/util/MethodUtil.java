package util;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reports.ExtentReportManager;
import reports.ExtentTestManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;


public class MethodUtil {

    private static final Logger log = LogManager.getLogger(MethodUtil.class);

    public static void threadSleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void elementToBeVisible(WebElement ele) {
        try {
            if (ele != null) {
                WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
                wait.until(ExpectedConditions.visibilityOf(ele));
            }
        } catch (Exception e) {
            System.err.println("Unable to locate element");
        }
    }

    public static void scrolltoElement(WebElement ele, String elementName) {
        try {
            if (ele != null) {
                elementToBeVisible(ele);
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                js.executeScript("arguments[0].scrollIntoView(true)", ele);
                System.out.println("✅ Scrolled to element " + elementName);
                log.info("✅ Scrolled to element " + elementName);
                //    ExtentReportManager.info("Scrolled to element"+elementName);
            }
        } catch (Exception e) {
            System.err.println("⚠ Unable to scroll to element");
            //      ExtentReportManager.info("Unable to scroll to element");
        }
    }

    public static void clickElement(WebElement element, String elementName) {
        try {
            if (element != null) {
                scrolltoElement(element, elementName);
                element.click();
                System.out.println("Succesfully Clicked on element " + elementName);
                ExtentReportManager.info("Succesfully Clicked on element " + elementName);
            }
        } catch (Exception e) {
            System.err.println("Unable to click on element " + elementName);
            ExtentReportManager.info("Unable to click on element" + elementName);
        }
    }

    public static void clickElementWithJS(WebElement element, String elementName) {
        try {
            if (element != null) {
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                scrolltoElement(element, elementName);
                js.executeScript("arguments[0].click()", element);
           //     js.executeScript("arguments[0].dispatchEvent(new Event('click', {bubbles: true}));", element);
                System.out.println("Succesfully Clicked on element " + elementName + " with javascript");
                ExtentReportManager.info("Succesfully Clicked on element " + elementName + " with javascript");
            }
        } catch (Exception e) {
            System.err.println("Unable to click on element " + elementName + " with JS ");
            ExtentReportManager.info("Unable to click on element " + elementName + " with JS ");
            System.err.println(e);
        }
    }

    public static void clickElementWithActionClass(WebElement element, String elementName) {
        try {
            if (element != null) {
                Actions act = new Actions(DriverManager.getDriver());
                scrolltoElement(element, elementName);
                act.moveToElement(element).pause(500).click().perform();
                System.out.println("Succesfully Clicked on element " + elementName + " with Action Class");
                ExtentReportManager.info("Succesfully Clicked on element " + elementName + " with Action Class");
            }
        } catch (Exception e) {
            System.err.println("Unable to click on element " + elementName + " with Action Class ");
            ExtentReportManager.info("Unable to click on element " + elementName + " with Action Class ");
            System.err.println(e);
        }
    }

    public static void doubleClickElement(WebElement element, String elementName) {
        try {
            if (element != null) {
                Actions act = new Actions(DriverManager.getDriver());
                scrolltoElement(element, elementName);
                act.doubleClick(element).build().perform();
                System.out.println("Succesfully Clicked on element " + elementName + " with Action Class");
                ExtentReportManager.info("Succesfully Clicked on element " + elementName + " with Action Class");
            }
        } catch (Exception e) {
            System.err.println("Unable to click on element " + elementName + " with Action Class ");
            ExtentReportManager.info("Unable to click on element " + elementName + " with Action Class ");
        }
    }

    public static void enterText(WebElement ele, String elementName, Object textToEnter) {
        try {
            if (ele != null && textToEnter != null) {
                scrolltoElement(ele, elementName);
                ele.sendKeys(String.valueOf(textToEnter));
                System.out.println("Entered Text " + textToEnter + " into " + elementName);
                ExtentReportManager.info("Entered Text " + textToEnter + " into " + elementName);

            }
        } catch (Exception e) {
            System.err.println("Unable to enter text into " + elementName);
            ExtentReportManager.info("Unable to enter text into " + elementName);
        }
    }

    public static void enterTextWithJS(WebElement ele, String elementName, String textToEnter)
    {
        try {
            JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
            js.executeScript("arguments[0].value='textToEnter';", ele);
            ExtentReportManager.info("Entered '"+textToEnter+"' into "+elementName);
            System.out.println("Entered "+textToEnter+" into "+elementName);
        } catch (Exception e)
        {
            System.err.println("Unable to enter "+textToEnter+" into "+elementName);
        }
    }

    public static void pressKey(WebElement ele,String keyName)
    {
        try {
            Keys key = Keys.valueOf(keyName.toUpperCase());  // Converts string to Keys enum
            ele.sendKeys(key);
            System.out.println("Pressed " + keyName + " Key");
    } catch (IllegalArgumentException e) {
        System.err.println("Invalid key name: " + keyName);
    } catch (Exception e)
        {
            System.err.println("Unable to press key");
        }
    }

    public static void selectOptionFromDropdownWithKey(WebElement ele, String elementName, String textToEnter) {
        try {
            if (ele != null && textToEnter != null) {
                enterText(ele, "", textToEnter);
                threadSleep(2);
            //    pressKey(ele);
            }
        } catch (Exception e) {
            System.err.println("Unable to enter text into " + elementName);
            ExtentReportManager.info("Unable to enter text into " + elementName);
            System.err.println(e);
        }
    }

    public static void switchToFrameWithElement(WebElement element)
    {
        try {
            DriverManager.getDriver().switchTo().frame(element);
            System.out.println("Switched to Frame");
        } catch (Exception e)
        {
            System.out.println("Unable to switch on frame");
        }
    }

    public static void switchToDefault()
    {
        try
        {
            DriverManager.getDriver().switchTo().defaultContent();
            System.out.println("Switched to default content");
        }catch (Exception e)
        {
            System.out.println("Unable to switch to defualt frame");
        }
    }

    public static void switchToFrameWithIndex(int num)
    {
        try {
            DriverManager.getDriver().switchTo().frame(num);
            System.out.println("Swithced to Iframe");
        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Unable to switch on frame");
        }
    }

    public static void switchToFrameWithID(WebElement element)
    {
        try {
            DriverManager.getDriver().switchTo().frame(element);
            System.out.println("Switched to frame");
        } catch (Exception e)
        {
            System.out.println("Unable to switch on frame");
        }
    }

    public static void assertTrue(WebElement ele, String elementName) {
        try {
            if (isDisplayed(ele, elementName)) {
                Assert.assertTrue(true, elementName + " is verified");
                ExtentReportManager.pass(elementName + " is verified");
            }
        } catch (Exception e) {
            ExtentReportManager.pass(elementName + " is not verified");
            System.out.println("Assert True Error");
            System.out.println(e);
        }
    }

    public static void assertFalse(WebElement ele, String elementName) {
        try {
            if (isDisplayed(ele, elementName)) {
                Assert.assertFalse(true, elementName + " is not verified");
                ExtentReportManager.fail(elementName + " is not verified");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Assert False Passed");
        }
    }

    public static void assertVerify(WebElement ele, String elementName) {
        elementToBeVisible(ele);
        if (!ele.equals(null) || ele!=null) {
            Assert.assertTrue(true, elementName + " is verified");
            ExtentReportManager.pass("Element "+elementName+" is verified");
        } else {
            Assert.assertTrue(false, elementName + " is verified");
            ExtentReportManager.fail("Element "+elementName+" is not verified");
        }
    }

    public static boolean isDisplayed(WebElement ele, String elementName) {
        boolean flag = false;
        try {
            if (ele != null) {
                elementToBeVisible(ele);
                ele.isDisplayed();
                System.out.println(elementName + " is displayed");
                flag = true;
            }
        } catch (Exception e) {
            System.err.println(elementName + " is not displayed");
            flag = false;
        }
        return flag;
    }

    public static boolean isEnabled(WebElement ele, String elementName) {
        boolean flag = false;
        try {
            if (ele != null) {
                elementToBeVisible(ele);
                ele.isEnabled();
                System.out.println(elementName + " is Enabled");
                flag = true;
            }
        } catch (Exception e) {
            System.err.println(elementName + " is disabled");
            flag = false;
        }
        return flag;
    }

    public static boolean isSelected(WebElement ele, String elementName) {
        boolean flag = false;
        try {
            if (ele != null) {
                elementToBeVisible(ele);
                ele.isSelected();
                System.out.println(elementName + " is Selected");
                flag = true;
            }
        } catch (Exception e) {
            System.err.println(elementName + " is not selected");
            flag = false;
        }
        return flag;
    }

    public static void selectOptionFromDropDown(List<WebElement> ele, String elementName, String option) {
        try {
            System.out.println(ele.size());

            for (WebElement e : ele) {
                if (getText(e, elementName).equals(option)) {
                    clickElement(e, elementName);
                }
            }
        } catch (Exception e) {

        }
    }

    public static String getText(WebElement ele, String elementName) {
        String retrivedText = null;
        try {
            retrivedText = ele.getText();
            log.info("Text " + retrivedText + " is retrieved from " + elementName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return retrivedText;
    }

    public static void uploadFileWithLocalForm(WebElement ele, String path) {
        threadSleep(2);

        // Create Robot class
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            log.error(e.getMessage());
        }

        // Copy File path to Clipboard
        StringSelection str = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        threadSleep(2);
        //Check OS for Windows
        //    if (BrowserInfoUtils.isWindows()) {
        // Press Control+V to paste
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // Release the Control V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);
        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Check OS for MAC
     /*   if (BrowserInfoUtils.isMac()) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(1000);

            //Open goto MAC
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);

            //Paste the clipboard value
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(1000);

            //Press Enter key to close the Goto MAC and Upload on MAC
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }*/

        log.info("Upload File with Local Form: " + path);
        if (ExtentTestManager.getExtentTest() != null) {
            ExtentReportManager.info("Upload File with Local Form: " + path);
        }
    }

    public static File getScreenshot() {
        try {
            if (DriverManager.getDriver() == null) {
                System.out.println("Driver is null — WebDriver is not initialized.");
                return null;
            }

            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

            // Ensure directory exists
            File screenshotDir = new File("screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                System.out.println("Screenshot directory created.");
            }

            File destination = new File(screenshotDir, "test_screenshot.png");
            FileUtils.copyFile(screenshot, destination);

            System.out.println("Screenshot saved successfully at: " + destination.getAbsolutePath());
            return destination;

        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}


