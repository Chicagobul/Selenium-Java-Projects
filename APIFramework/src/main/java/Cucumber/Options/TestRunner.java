package Cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue = {"stepDefinitions"} /*, tags = "@AddPlace"*/)
public class TestRunner
{
}

//we can give values dynamically from our features file through Examples tag in a pipeline manner
// for this change the Scenario tag to Scenario Outline and in Given tag pass the attribute/column name as following :
// Given Add Place Payload with "<name>" "<language>" "<address>"

//We can provide more rows as above if we want to run same test case with diff data-set the same test case will run the
// no. of times same as the no. of data-sets provided

//If we only have to run one scenario from our feature file then we can use tagging mechanism like this : tags = "@AddPlace"
//using keyword tags and then giving the name of the scenario

//We can run the tag of our choice with maven command such as :
//mvn test -Dcucumber.options="--tags @AddPlace"

/* To generate report for our execution we use maven cucumber reporting plugin(google it, you will get a gitHub project)
For this we have to write this :
 plugin = "json:target/jsonReports/cucumber-report.json"
It means we told our TestRunner that we need json reporting(json file) and have given the path to save that file
We are doing this as the plugin needs this file as an input :
<inputDirectory>${project.build.directory}/jsonReports</inputDirectory>
And to run this through cmd and generate report we have to use this command : mvn test verify
Go to this path : target/cucumber-html-reports/overview-features.html copy the path of this .html file and paste on google
 */

//To run the jenkins job with parameters give this command: test -Dcucumber.options="--tags @$tag"
//use dollor sign, all jenkins variables start with $ sign here tag is parameter name that we have used in our job