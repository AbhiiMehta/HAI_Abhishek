package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest test1)
    {
        extentTest.set(test1);
    }

    public static ExtentTest getExtentTest()
    {
        return extentTest.get();
    }

    public static void removeExtentTest()
    {
        extentTest.remove();
    }



}
