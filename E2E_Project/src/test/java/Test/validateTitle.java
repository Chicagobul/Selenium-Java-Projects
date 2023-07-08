package Test;

import Academy.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;

import java.io.IOException;

public class validateTitle extends Base
{
    public static Logger log = LogManager.getLogger("validateTitle");
    @BeforeTest
    public void initialise() throws IOException
    {
        driver = initialiseDriver();
        log.info("Driver is initialised");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to Home page");
    }

    @Test
    public void validateAppTitle() throws IOException
    {
        LandingPage lp = new LandingPage(driver);
        Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
        log.info("Sucessfully checked the page title");
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }
}
