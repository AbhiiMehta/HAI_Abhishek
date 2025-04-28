package pages;

import com.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageElements.LoginPageElement;
import pageElements.QuotePageElements;
import util.MethodUtil;
import java.lang.reflect.Method;
import java.util.logging.MemoryHandler;

public class QuotePage extends QuotePageElements {

    LoginPageElement lp;
    public QuotePage(WebDriver driver1) {
        super(driver1);
         lp = new LoginPageElement(DriverManager.getDriver());
    }

    public void createQuote()
    {
        String path ="D:\\HAI\\Testing Files\\500words.rtf";
        MethodUtil.clickElementWithJS(getRequestQuote(), "Request Quote");
        MethodUtil.clickElement(getCountryList(), "Country List Button");
        MethodUtil.selectOptionFromDropDown(getCountryListOption(),"Country List" ,"Egypt");
        MethodUtil.clickElementWithJS(getNextBtn(), "Next Button");
//        MethodUtil.clickElementWithJS(getuploadBtn(),"Upload Button");
//        MethodUtil.clickElementWithJS(getuploadBtn(),"Path");
        MethodUtil.enterText(getuploadBtn(),"Path",path);
        MethodUtil.threadSleep(10);
        if(MethodUtil.isDisplayed(getDisabledNextButton(),"Disabled Next Button")) {
            MethodUtil.threadSleep(5);
        }
        MethodUtil.clickElementWithJS(getNxtBtn2(), "Next Button");
        MethodUtil.clickElementWithActionClass(gettranslateFrom(), "Translate From");
        MethodUtil.selectOptionFromDropDown(gettranslateFromOption(),"Translate From Option","Chinese (Simplified, China)");
        MethodUtil.clickElementWithActionClass(getTranslateTo(), "Translate to");
        MethodUtil.clickElementWithActionClass(getTranslateToOption(), "Translate to");
        MethodUtil.clickElementWithJS(getNxtBtn3(),"Next Button");
        MethodUtil.clickElementWithJS(getSendMeQuote(),"Send Me A Quote");
        MethodUtil.assertVerify(getQuoteRequested(), "Quote Requested, Thanks");
    }

    public void clickOnReviewButton(String fileName)
    {
        MethodUtil.clickElementWithJS(getReviewButton(fileName), "Review Button");
    }


    public void uploadFile(String path) {
        MethodUtil.enterText(getuploadBtn(), "Path", path);
        MethodUtil.threadSleep(10);
        if (MethodUtil.isDisplayed(getDisabledNextButton(), "Disabled Next Button")) {
            MethodUtil.threadSleep(5);
        }
        MethodUtil.clickElementWithJS(getNxtBtn2(), "Next Button");

    }

    public void selectLanguageForTranslation() {
        MethodUtil.clickElementWithActionClass(gettranslateFrom(), "Translate From");
        MethodUtil.selectOptionFromDropDown(gettranslateFromOption(), "Translate From Option", "Chinese (Simplified, China)");
        MethodUtil.clickElementWithActionClass(getTranslateTo(), "Translate to");
        MethodUtil.clickElementWithJS(getTranslateToOptionQA("English (United Kingdom)"), "Translate to");
        MethodUtil.clickElementWithJS(getNxtBtn3(), "Next Button");
    }

    public void sendQuoteButton() {
        MethodUtil.clickElementWithJS(getSendMeQuote(), "Send Me A Quote");
    }

    public void verifyQuoteRequested(){
        MethodUtil.assertVerify(getQuoteRequested(), "Quote Requested, Thanks");
    }

    public void selectReasonForCancellation()
    {
        MethodUtil.clickElementWithActionClass(getRejectReasonButton(),"Reject Reason");
        MethodUtil.selectOptionFromDropDown(getRejectReasonOption(),"Reject Reasons","Other");
        MethodUtil.threadSleep(2);
        MethodUtil.enterText(getWriteReason(),"Write Reason","Oii oppjhh");
    }


    public void sendRejectRequest()
    {
        MethodUtil.clickElementWithJS(getSendButton(),"Send");
    }

    public void verifyQuoteRejected()
    {
        MethodUtil.assertVerify(getQuoteRejectVerification(),"Quote Reject Request");
    }


    public void forgotPassword()
    {
        MethodUtil.clickElementWithJS(getForgotPassLink(),"Forgot Password");
        MethodUtil.enterText(lp.getEmail(),"Email","repribrugroibroi-7133@yopmail.com");
        MethodUtil.clickElementWithJS(getSendMail(), "Send Password");
    }

    public void filterlangu()
    {
        MethodUtil.threadSleep(2);
       MethodUtil.clickElementWithJS(gettranslateFrom(), "Translate From");
        MethodUtil.selectOptionFromDropDown(gettranslateFromOption(),"Translate From Option","Chinese (Simplified, China)");
        MethodUtil.clickElementWithActionClass(getTranslateTo(), "Translate to");
        MethodUtil.clickElementWithJS(getTranslateToOptionQA("English (United Kingdom)"), "Translate to");
    }


    public void approveQuoteButton(String fileName) {
        MethodUtil.threadSleep(3);
        MethodUtil.clickElementWithJS(getApproveButton(fileName), "Approve Button");
    }

    public void approveQuoteWithTerms()
    {
        MethodUtil.clickElementWithActionClass(getTermsOfUse(), "Terms Of Use Checkbox");
        MethodUtil.clickElementWithJS(getApproveQuote(), "Approve Quote");
        MethodUtil.threadSleep(2);
    }

    public void selectAddressAndReviewSummary(String line1) {
        MethodUtil.clickElementWithJS(getSelectAddress(line1), "Select Address");
        MethodUtil.clickElementWithJS(getNextBtn(), "Next");
        MethodUtil.threadSleep(2);
        MethodUtil.clickElementWithJS(getNextBtn(), "Next");
    }

    public void addPaymentDetails(){
        MethodUtil.threadSleep(3);
        MethodUtil.switchToFrameWithElement(getPaymentIframe());
     //   MethodUtil.switchToFrameWithElement(getAnotherFrame());
        MethodUtil.enterText(getCardNumber(),"Card Number","5555555555554444");
        MethodUtil.threadSleep(3);
        MethodUtil.enterText(getCardHolderName(),"Adfasf","Master Card");
        MethodUtil.enterText(getExpriryMonth(),"Expiry Month","11");
        MethodUtil.enterText(getExpiryYear(),"Year","25");
        MethodUtil.enterText(getSecurityCode(),"Security Code","323");
        MethodUtil.clickElementWithJS(getSubmitButton(),"Submit Button");
        MethodUtil.switchToDefault();
}

    public void verifyQuoteTransaction()
    {
        MethodUtil.assertVerify(getTranSuccess(),"Transaction Succesfull");
    }

}
