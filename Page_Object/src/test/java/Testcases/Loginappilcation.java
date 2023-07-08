package Testcases;

import ObjectRepository.PageObjectFactory;
import ObjectRepository.RediffLoginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Loginappilcation
{
       @Test
       public void Login()
       {
           System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
           WebDriver driver = new ChromeDriver();
           driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

           /*RediffLoginpage rp = new RediffLoginpage(driver);
           rp.Email().sendKeys("hello");
           rp.Password().sendKeys("paswd");
           rp.submit().click();*/

           PageObjectFactory pf = new PageObjectFactory(driver);
           pf.Email().sendKeys("hello");
           pf.Password().sendKeys("paswd");
           pf.submit().click();
       }

}
