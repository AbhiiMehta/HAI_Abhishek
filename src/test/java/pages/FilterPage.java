package pages;

import com.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.FilterPageElements;
import util.MethodUtil;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FilterPage extends FilterPageElements {


    public FilterPage(WebDriver driver1) {
        super(driver1);
    }

    public void filterButton()
    {
        MethodUtil.threadSleep(6);
        if(MethodUtil.isDisplayed(getClearFilter(),"Clear Filter"))
        {
            clearFilter();
        }
        MethodUtil.clickElementWithJS(getFilter(),"Filter Button");
    }

    public void selectTranslationLanguage()
    {
        MethodUtil.clickElementWithActionClass(getTranslateFrom(),"Translate From Button");
        MethodUtil.threadSleep(2);
        MethodUtil.enterText(getTranslateFrom(),"Translate from language","Arabic (Saudi Arabia)");
        MethodUtil.clickElementWithJS(getTranslateFromOption(),"Translate From Language");
        MethodUtil.pressKey(getTranslateFrom(),"tab");
        MethodUtil.threadSleep(2);
        MethodUtil.clickElementWithJS(getTranslateTo(),"Translate To Button");
        MethodUtil.enterText(getTranslateTo(),"Translate to language","Czech (Czechia)");
        MethodUtil.clickElementWithJS(getTranslateToOption("Czech (Czechia)"),"Translate to language");
        MethodUtil.threadSleep(2);
    }

    public void verifyFilterApplied()
    {
        MethodUtil.assertVerify(getFiletrApplied(),"Filter Applied");
    }

    public void applyFilter()
    {
        MethodUtil.clickElementWithJS(getApply(),"Apply Button");
    }

    public void clearFilter()
    {
        if(MethodUtil.isDisplayed(getFiletrApplied(), "Filter Applied"))
        {
            MethodUtil.clickElementWithJS(getClearFilter(),"Clear Filter");
        }
    }
}
