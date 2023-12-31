package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
    public WebDriver driver;
    By email = By.cssSelector("#user_email");
    By password = By.cssSelector("#user_password");
    By login = By.xpath("//*[@name='commit']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getEmail()
    {
        return driver.findElement(email);
        // As signin is a webelement so the method should have a return type as Webelement
    }

    public WebElement getPassword()
    {
        return driver.findElement(password);
    }

    public WebElement getLoginButton()
    {
        return driver.findElement(login);
    }
}
