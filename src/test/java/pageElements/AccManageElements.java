package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccManageElements {

    WebDriver driver;

    public AccManageElements(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Manage Account']")
    WebElement manageAccount;

    public WebElement getManageAccount() {
        return manageAccount;
    }

    @FindBy(xpath = "//div//P[text()='Profile Management']")
    WebElement profileMangement;

    public WebElement getProfileMangement() {
        return profileMangement;
    }

    @FindBy(id = "Add_ContactNoBtn")
    WebElement addContactBtn;

    public WebElement getAddContactBtn() {
        return addContactBtn;
    }

    @FindBy(xpath = "//input[@placeholder='enterPhone']")
    WebElement enterContactNum;

    public WebElement getEnterContactNum() {
        return enterContactNum;
    }

    @FindBy(xpath = "//button[text()='SAVE']")
    WebElement saveButton;

    public WebElement getSaveButton() {
        return saveButton;
    }

    @FindBy(xpath = "//button[@data-testid='AccountCircleIcon']")
    WebElement accountButton;

    public WebElement getAccountButton() {
        return accountButton;
    }

    @FindBy(xpath = "//div//p[text()='Billing Preferences']")
    WebElement billlingPreference;

    public WebElement getBilllingPreference() {
        return billlingPreference;
    }

    @FindBy(id = "add_addressBtn")
    WebElement addAddress;

    public WebElement getAddAddress() {
        return addAddress;
    }

    @FindBy(id = "businessName")
    WebElement businessName;

    public WebElement getBusinessName() {
        return businessName;
    }

    @FindBy(id = "addressName")
    WebElement addressName;

    public WebElement getAddressName() {
        return addressName;
    }

    @FindBy(id = "streetAddress1")
    WebElement streetAddress1;

    public WebElement getStreetAddress1() {
        return streetAddress1;
    }

    @FindBy(id = "streetAddress2")
    WebElement streetAddress2;

    public WebElement getStreetAddress2() {
        return streetAddress2;
    }

    @FindBy(id = "city")
    WebElement city;

    public WebElement getCity() {
        return city;
    }

    @FindBy(id = "State/Region")
    WebElement State;

    public WebElement getState() {
        return State;
    }

    @FindBy(id = "postalCode")
    WebElement postalCode;

    public WebElement getPostalCode() {
        return postalCode;
    }


    @FindBy(id = "vat")
    WebElement vat;

    public WebElement getVat() {
        return vat;
    }


    @FindBy(id = "country")
    WebElement country;

    public WebElement getCountry() {
        return country;
    }

    public List<WebElement> getCountryName() {
        return driver.findElements(By.xpath("//div//ul//li[@role='option']"));
    }

    public WebElement getAddressAdded(String address) {
        return driver.findElement(By.xpath("//p[text()='"+address+"']"));
    }

    public WebElement selectBusinessType(String businessType)
    {
        return driver.findElement(By.xpath("//input[@value='"+businessType+"']"));
    }

    @FindBy(xpath="//p[text()='Select your customer type']")
    WebElement customerType;

    public WebElement getSelectCustomerTypePopup()
    {
        return customerType;
    }

    @FindBy(xpath="//div//h6[text()='Notifications']")
    WebElement notification;

    public WebElement getNotification()
    {
        return notification;
    }


    @FindBy(xpath="//input[@value='me']")
    WebElement meOnly;

    public WebElement getMeOnly()
    {
        return meOnly;
    }

    @FindBy(xpath="//input[@value='anyone']")
    WebElement anyone;

    public WebElement getAnyone()
    {
        return anyone;
    }


    @FindBy(xpath="//input[@value='BUSINESS']")
    WebElement business;

    public WebElement getBusiness()
    {
        return business;
    }


    @FindBy(xpath="//button[text()='NEXT']")
    WebElement next;

    public WebElement getNext()
    {
        return next;
    }

    @FindBy(xpath="//input[@value='PERSONAL']")
    WebElement personal;

    public WebElement getPersonal()
    {
        return personal;
    }
/*
    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }

    @FindBy(xpath="")
    WebElement ;

    public WebElement get()
    {
        return ;
    }
*/
}
