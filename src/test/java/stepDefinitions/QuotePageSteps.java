package stepDefinitions;

import com.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccManagePage;
import pages.LoginPage;
import pages.QuotePage;
import reports.ExtentReportManager;

public class QuotePageSteps {

    public LoginPage ln;
    public QuotePage qp;

    @Given("User is logged in")
    public void user_is_logged_in()
   {
        ln = new LoginPage(DriverManager.getDriver());
        qp = new QuotePage(DriverManager.getDriver());
        ln.loginQA();
        ln.navigateToHomePage();
   }

    @When("User click on create Quote Button")
    public void user_click_on_create_quote_button() {
        String path = "D:\\HAI\\Testing Files\\TestFile.docx";
        qp.uploadFile(path);
    }

    @When("confirm the languages for translation")
    public void confirm_the_languages_for_translation() {
        qp.selectLanguageForTranslation();
    }

    @When("click on send me a quote")
    public void click_on_send_me_a_quote() {
        qp.sendQuoteButton();
    }

    @Then("User receives a quote")
    public void user_receives_a_quote() {
        qp.verifyQuoteRequested();
    }


    @When("User click on Review Button")
    public void user_click_on_review_button() {
        qp.clickOnReviewButton("Word");
    }

    @When("Select the reason for Cancellation")
    public void select_the_reason_for_cancellation() {
        qp.selectReasonForCancellation();
    }

    @When("clicks on send button")
    public void clicks_on_send_button() {
        qp.sendRejectRequest();
    }
    @Then("User Quote has been rejected")
    public void user_quote_has_been_rejected() {
        qp.verifyQuoteRejected();
    }

    @When("User click on Approve Button")
    public void user_click_on_approve_button() {
        qp.approveQuoteButton("TestFile");
    }

    @When("Accept T&C and click on the Approve Quote Button")
    public void accept_t_c_and_click_on_the_approve_quote_button() {
            qp.approveQuoteWithTerms();
    }

    @When("Select address and review summary")
    public void select_address_and_review_summary() {
        qp.selectAddressAndReviewSummary("sji1GCmXx");

    }
    @When("Enter Payment details and make payment")
    public void enter_payment_details_and_make_payment() {
        qp.addPaymentDetails();
    }

    @Then("Verify transaction has been succesfull")
    public void verify_transaction_has_been_succesfull() {
        qp.verifyQuoteTransaction();
    }


}
