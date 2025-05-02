package stepDefinitions;

import com.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccManagePage;
import pages.LoginPage;
import pages.QuotePage;
import util.RandomUtil;

public class AccManageSteps {

    LoginPage lp;
    QuotePage qp;
    AccManagePage ap;

    String addressLine1;
    String businessName;

    @Given("user is logged in acc")
    public void user_is_logged_in_acc() {
        lp = new LoginPage(DriverManager.getDriver());
        ap = new AccManagePage(DriverManager.getDriver());
        lp.loginQA();
        lp.navigateToHomePage();
    }


    @When("Click on Profile Management in the Account Management page")
    public void click_on_profile_management_in_the_account_management_page() {
        ap.manageAccount();
    }

    @When("Click the Add Contact Number button")
    public void click_the_add_contact_number_button() {
        ap.profileManage();
    }


    @When("Select the country code, enter a contact number, and click SAVE")
    public void select_the_country_code_enter_a_contact_number_and_click_save() {
        ap.addContact();
    }

    @Then("Verify that the newly added contact number is displayed on the My Profile page")
    public void verify_that_the_newly_added_contact_number_is_displayed_on_the_my_profile_page() {
        ap.saveContact();
    }


 /*   @When("Click on Profile Management in the Account Management page")
    public void click_on_profile_management_in_the_account_management_page() {
        lp = new LoginPage(DriverManager.getDriver());
        lp.loginQA();
        ap = new AccManagePage(DriverManager.getDriver());
        ap.manageAccount();

    }
 */

    @When("Click the Add address button")
    public void click_the_add_address_button() {
        ap.clickOnBillingPref();
    }

    @When("Fill in all required fields.")
    public void fill_in_all_required_fields() {
        businessName = RandomUtil.randomString(8);
        addressLine1 = RandomUtil.randomString(9);
        ap.enterAddress(businessName, addressLine1);
    }

    @When("click on the save button")
    public void click_on_the_save_button() {
        // Write code here that turns the phrase above into concrete actions
        ap.saveAddress();
    }

    @Then("Verify that the newly added address is displayed on the My Profile page")
    public void verify_that_the_newly_added_address_is_displayed_on_the_my_profile_page() {
        ap.verifyNewAddressAdded(addressLine1);
    }


    @When("Add a new address via Billing Preferences.")
    public void add_a_new_address_via_billing_preferences() {
        businessName = RandomUtil.randomString(8);
        addressLine1 = RandomUtil.randomString(9);
        ap.manageAccount();
        ap.clickOnBillingPref();
        ap.enterAddress(businessName, addressLine1);
        ap.saveAddress();
        lp.navigateToHomePage();
    }

    @When("Navigate to the CC payment flow and verify the new address is displayed")
    public void navigate_to_the_cc_payment_flow_and_verify_the_new_address_is_displayed() {

        qp = new QuotePage(DriverManager.getDriver());
        qp.approveQuoteButton("1000Words");
        qp.approveQuoteWithTerms();
    }

    @Then("Navigate to the Pay by Invoice flow and verify the new address is displayed.")
    public void navigate_to_the_pay_by_invoice_flow_and_verify_the_new_address_is_displayed() {
        qp.selectAddressAndReviewSummary("sji1GCmXx");
    }

}
