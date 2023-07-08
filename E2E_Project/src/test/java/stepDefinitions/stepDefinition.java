package stepDefinitions;

import Academy.Base;
import cucumber.api.java.en.*;
import org.testng.Assert;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.portalHomePage;

import java.io.IOException;

// If you are doing the parameterization then use Scenario Outline in your .feature file instead of only scenario
// When you use <> these arrows in the feature file then it assumes that data is being driven from Examples and it tries
// to match the column name in it (it should always match)

public class stepDefinition extends Base
{
    @Given("^Initialise driver with chrome browser$")
    public void initialise_driver_with_chrome_browser() throws IOException {
        driver = initialiseDriver();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) {
        LoginPage l = new LoginPage(driver);
        l.getEmail().sendKeys(username);
        l.getPassword().sendKeys(password);
        l.getLoginButton().click();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in()
    {
        portalHomePage p = new portalHomePage(driver);
        Assert.assertTrue(p.getSearchBox().isDisplayed());
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String arg1)
    {
       driver.get(arg1);
    }

    @And("^Clicking on login link on home page to land on sign in page$")
    public void clicking_on_login_link_on_home_page_to_land_on_sign_in_page()
    {
        LandingPage lp = new LandingPage(driver);
        lp.getLogin().click();
    }

    @And("^Close the Browsers$")
    public void close_the_browsers()
    {
        driver.quit();
    }

}
