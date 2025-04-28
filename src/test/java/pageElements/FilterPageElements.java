package pageElements;

import com.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilterPageElements {

    WebDriver driver;
    public FilterPageElements(WebDriver driver1)
    {
        this.driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath="//span[text()='Filter']")
    WebElement filter;

    public WebElement getFilter()
    {
        return filter;
    }

    @FindBy(xpath="//input[@id='sourceLanugages-tags-render']")
    WebElement translanteFrom;

    public WebElement getTranslateFrom()
    {
        return translanteFrom;
    }

    @FindBy(xpath="//div[@role='presentation']//div[contains(text(),'Arabic')]")//div//input[@value='Quoting']")
    WebElement translateLanguage;

    public WebElement getTranslateLanguage()
    {
        return translateLanguage;
    }

    public WebElement getTranslateFromOption()
    {
        return DriverManager.getDriver().findElement(By.xpath("//div[@role='presentation']//div[contains(text(),'Arabic')]"));
    }

    @FindBy(xpath="//input[@id='TargetLanguages-tags-render']")
    WebElement translanteTo;

    public WebElement getTranslateTo()
    {
        return translanteTo;
    }

    public  WebElement getTranslateToOption(String language)
    {
        return driver.findElement(By.xpath("//ul[@id='TargetLanguages-tags-render-listbox']//li//div[text()='"+language+"']"));

    }

    @FindBy(id="hubspot-conversations-iframe")
    WebElement frame;

    public WebElement getFrame()
    {
        return frame;
    }

    @FindBy(xpath = "//button[text()='APPLY']")
    WebElement apply;

    public WebElement getApply()
    {
        return apply;
    }

    @FindBy(xpath="//span[text()='Filter Applied']")
    WebElement filterApplied;

    public WebElement getFiletrApplied()
    {
        return  filterApplied;
    }

    @FindBy(xpath="//div[text()='Clear']")
    WebElement clearFilter;

    public WebElement getClearFilter()
    {
        return  clearFilter;
    }

}
