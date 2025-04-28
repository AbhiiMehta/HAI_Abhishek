package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager
{
    static ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    public static void setDriver(WebDriver driver)
    {
       DriverManager.driver.set(driver);
    }

    public static WebDriver getDriver()
    {
      return driver.get();
    }

    public static void quit()
    {
        getDriver().quit();
    }
}
