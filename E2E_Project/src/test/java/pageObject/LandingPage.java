package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage
{
    public WebDriver driver;
    By signin = By.cssSelector("a[href*='sign_in']");
    By title = By.xpath("//h2[text()='Featured Courses']");
    By NavBar = By.xpath("//*[contains(@class, 'navbar')]");

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        // We created this constructor as the driver that we are returning to the HomePage class has no life
        // so by this we have assigned the driver object in Homepage which has life to the driver obj
        // in this class and have passed this driver as an argument in the LandingPage class obj
        // In the code this.driver = driver the 1st driver obj is of this class and the 2nd one is of
        // HomePage class
    }

    public WebElement getLogin()
    {
        return driver.findElement(signin);
        // As signin is a webelement so the method should have a return type as Webelement
    }

    public WebElement getTitle()
    {
        return driver.findElement(title);
    }

    public WebElement getNavigationBar()
    {
        return driver.findElement(NavBar);
    }
}

/* <resources>
   <resource>
   <directory>src/main/resources</directory>
   <filtering>true</filtering>
   </resource>
   </resources>

->We are using this tag in our pom.xml file so that while execution it will consider these files also which
are in our resources folder hence will check the lo4j file also
->It called resource filtering
 */
//In testng xml file we are using every class names in diff test folders as @AfterTest tag was earlier
//considering all the classes as single hence was closing the browser after execution of all the classes so
//to get rid of this issue we are using this technique
//To run our test cases in parallel mode declare webdriver obj locally in all classes so that all the classes
//can use the fresh obj and will not override it
