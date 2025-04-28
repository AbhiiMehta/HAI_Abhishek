package pageElements;

import com.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QuotePageElements {

    WebDriver driver;
    public QuotePageElements(WebDriver driver1)
    {
        this.driver =driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//button[@id='btn-startnewproject']")
    WebElement requestQuote;

    public WebElement getRequestQuote() {
        return requestQuote;
    }

    @FindBy(xpath = "//button[text()='NEXT']")
    WebElement nextBtn;

    public WebElement getNextBtn() {
        return nextBtn;
    }

    @FindBy(xpath = "//button[@id='step1-btn-next']")
    WebElement nxtBtn2;

    public WebElement getNxtBtn2() {
        return nxtBtn2;
    }

    @FindBy(xpath = "//button[@id='step2-btn-next']")
    WebElement nxtBtn3;

    public WebElement getNxtBtn3() {
        return nxtBtn3;
    }

    @FindBy(xpath = "//input[@data-testid='upload']")//"//button[@id='btn-startnewproject' and text()='UPLOAD']")
    WebElement uploadBtn;

    public WebElement getuploadBtn() {
        return uploadBtn;
    }

    @FindBy(xpath = "//input[@id='step2-src-language']")
    WebElement translateFrom;

    public WebElement gettranslateFrom() {
        return translateFrom;
    }

    @FindBy(xpath = "//div//ul[@id='step2-src-language-listbox']//li")
    List<WebElement> translateFromOption;

    public List<WebElement> gettranslateFromOption() {
        return translateFromOption;
    }

    @FindBy(xpath = "//input[@id='checkboxes-tags-demo']")
    WebElement translateTo;

    public WebElement getTranslateTo() {
        return translateTo;
    }

    @FindBy(xpath = "//div//ul//input[@id='Check-box']")
    WebElement translateToOption;

    public WebElement getTranslateToOption() {
        return translateToOption;
    }

    public WebElement getTranslateToOptionQA(String text) {
        return driver.findElement(By.xpath("//div//ul//li//div[text()='" + text + "']"));
    }

    public WebElement getReviewButton(String text) {
        return driver.findElement(By.xpath("//div[text()='"+text+"']//ancestor::span//button[text()='Review']"));
    }

    @FindBy(id="reject")
    WebElement rejectReasonButton;

    public WebElement getRejectReasonButton()
    {
        return rejectReasonButton;
    }


    @FindBy(xpath = "//button[text()='SEND ME A QUOTE']")
    WebElement sendMeQuote;

    public WebElement getSendMeQuote() {
        return sendMeQuote;
    }

    @FindBy(xpath = "//div//ul[@aria-labelledby='hsbc-country-label']//li")
    List<WebElement> countryListOption;

    public List<WebElement> getCountryListOption() {
        return countryListOption;
    }

    @FindBy(xpath = "//div//input[@id='hsbc-country']")
    WebElement countryList;

    public WebElement getCountryList() {
        return countryList;
    }

    @FindBy(xpath="//div[text()='Thanks!']")
    WebElement quoteRequested;

    public WebElement getQuoteRequested()
    {
        return quoteRequested;
    }

    @FindBy(xpath="//button[@disabled]")
    WebElement disabledNextButton;

    public WebElement getDisabledNextButton()
    {
        return disabledNextButton;
    }


    @FindBy(xpath="//ul//li")
    List<WebElement> rejectReasonOption;

    public List<WebElement> getRejectReasonOption()
    {
        return rejectReasonOption;
    }

    @FindBy(xpath="//button[text()='SEND']")
    WebElement sendButton;

    public WebElement getSendButton()
    {
        return sendButton;
    }

    @FindBy(xpath="//div//textarea[@placeholder='Please type your reason here.']")
    WebElement writeReason;

    public WebElement getWriteReason()
    {
        return writeReason;
    }

    @FindBy(xpath="//div//h5[text()='Your request has been sent to the team who will review this and be in touch.']")
    WebElement quoteRejectVerification;

    public WebElement getQuoteRejectVerification()
    {
        return quoteRejectVerification;
    }

    @FindBy(xpath="//p[@class='auth0-lock-alternative']//a")
    WebElement forgotPassLink;

    public WebElement getForgotPassLink() {
        return forgotPassLink;
    }

    @FindBy(xpath="//span[text()='Send email']")
    WebElement sendMail;

    public WebElement getSendMail()
    {
        return sendMail;
    }

    public WebElement getApproveButton(String text) {
        return driver.findElement(By.xpath("//div[text()='"+text+"']//ancestor::span//button[text()='APPROVE']"));
    }

    @FindBy(xpath="//input[@type='checkbox']")
    WebElement termsOfUse;

    public WebElement getTermsOfUse()
    {
        return termsOfUse;
    }

    @FindBy(xpath="//button[text()='APPROVE QUOTE']")
    WebElement approveQuote;

    public WebElement getApproveQuote()
    {
        return approveQuote;
    }

    public WebElement getSelectAddress(String address)
    {
        return driver.findElement(By.xpath("//div//strong[text()='"+address+"']"));
    }

    @FindBy(xpath="//div//input[@id='cardNumber']")
    WebElement cardNumber;

    public WebElement getCardNumber()
    {
        return cardNumber;
    }

    @FindBy(id="cardholderName")
    WebElement cardHolderName;

    public WebElement getCardHolderName()
    {
        return cardHolderName;
    }

    @FindBy(id="expiryMonth")
    WebElement expriryMonth;

    public WebElement getExpriryMonth() {
        return expriryMonth;
    }

    @FindBy(id="expiryYear")
    WebElement expiryYear;

    public WebElement getExpiryYear() {
        return expiryYear;
    }

    @FindBy(id="securityCode")
    WebElement securityCode;

    public WebElement getSecurityCode() {
        return securityCode;
    }

    @FindBy(id="submitButton")
    WebElement submitButton;

    public WebElement getSubmitButton() {
        return submitButton;
    }

    @FindBy(xpath="//div[@id='wp-cl']//iframe[@id='wp-cl-custom-tag-iframe']")
    WebElement paymentIframe;

    public WebElement getPaymentIframe()
    {
        return paymentIframe;
    }

    @FindBy(id="chat-widget-iframe")
    WebElement helpFrame;

    public WebElement getHelpFrame()
    {
        return helpFrame;
    }

    @FindBy(xpath="//div[@class='MuiDialogContent-root css-1hg8j8q']//h6[contains(text(),'successful')]")
    WebElement tranSuccess;

    public WebElement getTranSuccess()
    {
        return tranSuccess;
    }
}
