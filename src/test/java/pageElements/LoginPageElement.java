package pageElements;

import com.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElement {

    WebDriver driver;
    public LoginPageElement(WebDriver driver1)
    {
       this.driver = driver1;
        PageFactory.initElements(driver1, this);
    }

 /*   WebElement register = driver.findElement(By.xpath("//button[@id='Register-id']"));
    WebElement email = driver.findElement(By.xpath("//input[@id='1-email']"));
    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
    WebElement submit = driver.findElement(By.xpath("//button[@name='submit']"));
    WebElement startNewProject = driver.findElement(By.xpath("//span[text()='Filter']"));
    WebElement accounts = driver.findElement(By.xpath("//button[@data-testid='AccountCircleIcon']"));
    WebElement logoutButton = driver.findElement(By.id("logout-id"));*/


    @FindBy(xpath ="//button[@id='Register-id']")
    WebElement register;

    public WebElement getRegister()
    {
        return  register;
    }

    @FindBy(xpath="//input[@id='1-email']")
    WebElement email;

    public WebElement getEmail()
    {
        return email;
    }

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    public WebElement getPassword()
    {
        return password;
    }

    @FindBy(xpath="//button[@name='submit']")
    WebElement submit;

    public WebElement getSubmit()
    {
        return submit;
    }

    @FindBy(xpath="//span[text()='Filter']")
    WebElement startNewProject;

    public WebElement getStartNewProject()
    {
        return startNewProject;
    }

    @FindBy(xpath="//button[@data-testid='AccountCircleIcon']")
    WebElement accountButton;

    public WebElement getAccountButton()
    {
        return accountButton;
    }

    @FindBy(xpath="//button[text()='Sign In']")
    WebElement signIn;

    public WebElement getSignIn()
    {
        return signIn;
    }

    @FindBy(xpath="//div//img[@alt='HAI']")
    WebElement home;

    public WebElement getHome()
    {
        return home;
    }
}
