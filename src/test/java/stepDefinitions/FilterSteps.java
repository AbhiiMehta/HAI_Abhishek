package stepDefinitions;

import com.driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FilterPage;
import pages.LoginPage;
import pages.QuotePage;

public class FilterSteps {

    LoginPage lp ;
    FilterPage fp;
    @When("User Click on Filter Button")
    public void user_click_on_filter_button() {
        lp = new LoginPage(DriverManager.getDriver());
        lp.loginQA();
        fp= new FilterPage(DriverManager.getDriver());
        fp.filterButton();

    }
    @When("Select translation languages")
    public void select_translation_languages() {
        fp.selectTranslationLanguage();
    }

    @When("Clicks on Apply Button")
    public void clicks_on_apply_button() {
        fp.applyFilter();
    }

    @Then("Filter applies on Dashboard")
    public void filter_applies_on_dashboard() {
        fp.verifyFilterApplied();
    }

}
