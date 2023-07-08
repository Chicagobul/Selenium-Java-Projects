package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class RediffLoginpage
{
   WebDriver driver;
   public RediffLoginpage(WebDriver driver)
   {
       this.driver = driver;
   }
   //To use the driver obj from Loginapplication file we have created this constructor

   By username = By.xpath("//*[@id='login1']");
   By password = By.xpath("//*[@id='password']");
   By go = By.xpath("//*[@name='proceed']");

   public WebElement Email()
   {
       return driver.findElement(username);
   }
   //as we are returning a web element so the return type should also be of WebElement type

    public WebElement Password()
    {
        return driver.findElement(password);
    }

    public WebElement submit()
    {
        return driver.findElement(go);
    }

}
