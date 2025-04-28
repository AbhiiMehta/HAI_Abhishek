package com.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TargetFactory {

    WebDriver driver;
    public WebDriver target(String opt, String browserName)
    {
        if(opt.equalsIgnoreCase("local"))
        {
            //We need to use valueOf concept while reading the value From Enum
            driver = BrowserFactory.valueOf(browserName.toUpperCase()).createDriver();
        }
        else if (opt.equalsIgnoreCase("remote"))
        {
            driver = createRemoteInstance(BrowserFactory.valueOf(browserName.toUpperCase()).getOptions());
        }
        return driver;
    }

    //change private to public while learning browserstack
    public RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
         //   String gridURL = String.format("http://%s:%s", "localhost", 4444);
            String gridURL ="https://"+"abhishekmehta_0MkUKu"+":"+"JpA9es1nvXMjyMTgupdZ"+"@hub-cloud.browserstack.com/wd/hub";
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
        } catch (java.net.MalformedURLException e) {
            System.out.println("Grid URL is invalid or Grid Port is not available");
            //  LogUtils.error(String.format("Browser: %s", capability.getBrowserName()), e);
        } catch (IllegalArgumentException e) {
            //  LogUtils.error(String.format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
        }

        return remoteWebDriver;
    }


}
