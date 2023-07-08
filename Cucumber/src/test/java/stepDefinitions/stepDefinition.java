package stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// When ever you have to give an input in the gherkin line in .feature file use " "
// cucumber BDD consider it as a dynamic input which keeps on changing so it uses a regular expression
// to show it

public class stepDefinition
{
    @Given("^User is on Netbanking landing page$")
    public void user_is_on_Netbanking_landing_page() {
        System.out.println("navigated to the url");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() {
        System.out.println("logged-in success");
    }

    @When("^User login into application with username = \"([^\"]*)\" and password = \"([^\"]*)\"$")
    public void user_login_into_application_with_username_something_and_password_something(String strArg1, String strArg2) {
        System.out.println(strArg1);
        System.out.println(strArg2);
    }

    @Then("^Homepage is opened$")
    public void homepage_is_opened() {
        System.out.println("validated homepage");
    }

    @And("^Cards are displayed = \"([^\"]*)\"$")
    public void cards_are_not_displayed_something(String arg1) {
        System.out.println(arg1);
    }
}
