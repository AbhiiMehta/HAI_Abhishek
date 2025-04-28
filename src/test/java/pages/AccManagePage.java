package pages;

import org.openqa.selenium.WebDriver;
import pageElements.AccManageElements;
import util.MethodUtil;

import java.lang.reflect.Method;

public class AccManagePage extends AccManageElements {

    public AccManagePage(WebDriver driver1) {
        super(driver1);
    }

    public void profileManage() {
        MethodUtil.clickElementWithJS(getProfileMangement(), "Profile Mangement");
    }

    public void addContact(){
        MethodUtil.clickElementWithJS(getAddContactBtn(), "Add Contact");
        MethodUtil.enterText(getEnterContactNum(), "Enter Contact", "5556664455");
    }

        public void saveContact(){
        MethodUtil.clickElementWithJS(getSaveButton(), "Save Contact");
        //Verification remaining
    }

    public void verifyNewAddressAdded(String newAddress) {
        if (MethodUtil.isEnabled(getSaveButton(), "Save Button")) {
            MethodUtil.clickElementWithActionClass(getSaveButton(), "Save");
        }
        MethodUtil.assertVerify(getAddressAdded(newAddress), "Address Added");
    }

    public void updateNotification() {
        MethodUtil.clickElementWithJS(getNotification(), "Notification");
        if (MethodUtil.isSelected(getMeOnly(),"Me Only")) {
            MethodUtil.clickElementWithJS(getAnyone(), "Anyone");
            MethodUtil.threadSleep(5);
            MethodUtil.clickElementWithJS(getSaveButton(), "Save");
        } else {
            MethodUtil.assertVerify(getNotification(), "Notification");
        }
    }

    public void newUser(String userType)
    {
        if(userType.equals("Personal"))
        {
            MethodUtil.clickElementWithJS(selectBusinessType("Personal"), "Business Type Button");
        }
        MethodUtil.clickElementWithJS(getNext(),"Next");
        MethodUtil.assertVerify(getNotification(),"Notification");
    }

    public void manageAccount()
    {
        if(MethodUtil.isDisplayed(getSelectCustomerTypePopup(),"Business Type"))
        {
            newUser("Business");
        }
        MethodUtil.clickElementWithJS(getAccountButton(), "Account Button");
        MethodUtil.clickElementWithJS(getManageAccount(), "Manage Account");
    }

    public void clickOnBillingPref()
    {
        MethodUtil.clickElementWithJS(getBilllingPreference(), "Billing pref");
    }

    public void enterAddress(String businessname, String line1) {
        MethodUtil.clickElementWithJS(getAddAddress(), "Add Address");
        MethodUtil.threadSleep(3);
        MethodUtil.enterText(getBusinessName(), "BusinessName", businessname);
        MethodUtil.enterText(getAddressName(), "Address Name", line1);
        MethodUtil.enterText(getStreetAddress1(), "AddressLine1 ", businessname);
        MethodUtil.enterText(getStreetAddress2(), "AddressLine2 ", line1);
        MethodUtil.enterText(getCity(), "citY", "city Name");
        MethodUtil.clickElementWithActionClass(getCountry(), "Country");
        MethodUtil.selectOptionFromDropDown(getCountryName(), "country", "Afghanistan");
        MethodUtil.enterText(getState(), "State", "Madhya Pradesh");
        MethodUtil.enterText(getPostalCode(), "postal code", "31241");
        //   MethodUtil.enterText(getVat(),"vat","2324");
    }

    public void saveAddress()
        {
            if (MethodUtil.isEnabled(getSaveButton(), "Save Button")) {
                MethodUtil.clickElementWithActionClass(getSaveButton(), "Save");
            }
            MethodUtil.assertVerify(getAddAddress(), "Address Button");
        }
}


