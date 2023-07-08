package cucumberOptions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature/Login.feature", glue = "stepDefinitions")

// StepDefinition and CucumberOptions should have same parent (not mandatory)
// There should be one implementation for each Gherkin line
//for step definition we just have to pass the package name in 'glue' parameter

public class TestRunner
{

}
