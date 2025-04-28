package pages;

import com.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElements.LoginPageElement;
import util.MethodUtil;

public class LoginPage extends LoginPageElement {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login()
    {
        MethodUtil.clickElementWithJS(getRegister(),"Register");
        MethodUtil.threadSleep(6);
        MethodUtil.enterText(getEmail(),"Email", "abhishek.mehta@rws.com");
        MethodUtil.enterText(getPassword(),"Password","Oriental@1234567");
        MethodUtil.clickElement(getSubmit(),"Submit");
        MethodUtil.assertTrue(getStartNewProject(),"Start New Project");
    }

    public void navigateToHomePage()
    {
        MethodUtil.clickElementWithJS(getHome(), "HomePage");
        MethodUtil.threadSleep(15);
    }

    public void loginQA() {

        MethodUtil.clickElementWithJS(getAccountButton(), "Account Button");
        if (MethodUtil.isDisplayed(getSignIn(), "Sign In")) {
            MethodUtil.clickElementWithJS(getSignIn(), "Sign In");
            MethodUtil.threadSleep(6);
            MethodUtil.enterText(getEmail(), "Email", "seumoprufeuno-6497@yopmail.com");
            MethodUtil.enterText(getPassword(), "Password", "Orienta!@#2345678");
            MethodUtil.clickElement(getSubmit(), "Submit");
            MethodUtil.threadSleep(10);
            //     MethodUtil.clickElementWithJS(getStartNewProject(),"Start New Project");
        }
    }
}
