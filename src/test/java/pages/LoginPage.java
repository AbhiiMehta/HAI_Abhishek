package pages;

import com.driver.DriverManager;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElements.LoginPageElement;
import util.MethodUtil;

public class LoginPage extends LoginPageElement {

    FilterPage fp;
    public LoginPage(WebDriver driver) {
        super(driver);
        fp = new FilterPage(driver);

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
        if(MethodUtil.isDisplayed(fp.getFilterWord(),"Filter Word"))
        {
            System.out.println("Already Logged In");
        }
        MethodUtil.clickElementWithJS(getAccountButton(), "Account Button");
        if (MethodUtil.isDisplayed(getSignIn(), "Sign In")) {
            MethodUtil.clickElementWithJS(getSignIn(), "Sign In");
            MethodUtil.threadSleep(6);
            MethodUtil.enterText(getEmail(), "Email", "leugritennuwe-3352@yopmail.com");
            MethodUtil.enterText(getPassword(), "Password", "Orienta!@#2345678");
            MethodUtil.clickElement(getSubmit(), "Submit");
            MethodUtil.threadSleep(10);
            //     MethodUtil.clickElementWithJS(getStartNewProject(),"Start New Project");
        }
    }
}
