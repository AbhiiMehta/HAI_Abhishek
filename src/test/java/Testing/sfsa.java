package Testing;

import com.driver.BrowserFactory;
import com.driver.DriverManager;
import org.testng.annotations.Test;

public class sfsa {

    @Test
    public void tst()
    {
    //    DriverManager.setDriver(BrowserFactory.browser("chrome"));
        DriverManager.getDriver().get("https://www.google.com");
    }
}
