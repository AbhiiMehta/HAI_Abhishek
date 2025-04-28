package stepDefinitions;

import com.driver.BrowserFactory;
import com.driver.DriverManager;
import io.cucumber.java.en.*;
import pages.LoginPage;
import reports.ExtentReportManager;
import reports.ExtentTestManager;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginSteps {

    LoginPage ln ;
    @Given("User is navigated to HAI User Page")
    public void user_is_navigated_to_hai_user_page() {
    //    DriverManager.setDriver(BrowserFactory.browser("chrome"));
    }
    @When("User Enters Username and Password")
    public void user_enters_username_and_password() {
        ln = new LoginPage(DriverManager.getDriver());
        ln.login();
    }
    @When("Clicks on Submit Button")
    public void clicks_on_submit_button() {

    }
    @Then("User gets Logged in Succesfully")
    public void user_gets_logged_in_succesfully() {

    }

}
