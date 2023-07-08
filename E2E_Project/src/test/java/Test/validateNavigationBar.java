package Test;

import Academy.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;

import java.io.IOException;

public class validateNavigationBar extends Base
{
    public static Logger log = LogManager.getLogger("validateNavigationBar");
    @BeforeTest
    public void initialise() throws IOException
    {
        driver = initialiseDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validateAppNavBar() throws IOException
    {
        LandingPage lp = new LandingPage(driver);
        Assert.assertTrue(lp.getNavigationBar().isDisplayed());
        log.info("Navigationbar is displayed");
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }
}
