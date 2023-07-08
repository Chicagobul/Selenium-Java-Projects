package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectFactory
{
    WebDriver driver;

    public PageObjectFactory(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //this we are initialising the FindBy tags of page factory class
    }

   /*By username = By.xpath("//*[@id='login1']");
   By password = By.xpath("//*[@id='password']");
   By go = By.xpath("//*[@name='proceed']");*/

    @FindBy(xpath = "//*[@id='login1']")
    WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@name='proceed']")
    WebElement go;

    public WebElement Email()
    {
        return username;
    }

    public WebElement Password()
    {
        return password;
    }

    public WebElement submit()
    {
        return go;
    }

}
