package Test;


import Academy.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;

import java.io.IOException;

public class HomePage extends Base
{
    public static Logger log = LogManager.getLogger("HomePage");
    @BeforeTest
    public void initialise() throws IOException
    {
        driver = initialiseDriver();
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String password) throws IOException
    {
        driver.get(prop.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.getLogin().click();
        LoginPage l = new LoginPage(driver);
        l.getEmail().sendKeys(username);
        l.getPassword().sendKeys(password);
        l.getLoginButton().click();
        log.info("Success");

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[2][2];
        // Row stands for how many diff type of data should run
        // Column stands for how many values per each data

        // 0th row
        data[0][0] = "nonresticteduser@qa.com";
        data[0][1] = "123456";
        // 1st row
        data[1][0] = "resticteduser@qa.com";
        data[1][1] = "789123";
        return data;
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }
}
