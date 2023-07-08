package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Report
{
    ExtentReports extent;


    @BeforeTest

    public void config()
    {

        //ExtentSparkReporter class is a support class to ExtentReports class, it is used to set the properties
        // to our generated report and to give the path to it
        //This class is responsible to generate the html file i.e report

        String path = System.getProperty("user.dir") + "\\reports\\index.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Web Automation Results");

        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        //ExtentReports class is the main class responsible to drive all the reporting execution

        extent.attachReporter(reporter);
        //attaching our generated file to main class

        extent.setSystemInfo("Tester", "Rahul Singh");

    }

    @Test

    public void initialDemo()
    {

        ExtentTest test = extent.createTest("Initial Demo");
        //attaching our test case report to our main class i.e ExtentReport so that it knows that a test case
        // is being executed and a report has to be created for this testcase

        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com");

        System.out.println(driver.getTitle());

        driver.close();

        //test.fail("Result do not match");

        extent.flush();
        //we use this to notify that our execution is done and report class doesn't have to monitor this from
        // now, it is mandatory

    }

}

/*    Extent Reports contain two major classes that are used frequently.

        ExtentReports class
        ExtentTest class
        Syntax:

        ExtentReports reports = new ExtentReports(“Path of directory to store the resultant HTML file”, true/false);

        ExtentTest test = reports.startTest(“TestName”);

        Extent Reports class is used to generate an HTML report on the user-specified path. The Boolean flag indicates if
        the existing report needs to be overwritten or a new report needs to be created. Value ‘true’ is the default value,
        which means all the existing data will be overwritten.

        Extent Test class is used to log test steps onto the generated HTML report.

        The above classes can be used with the frequently used built-in methods that are stated below.

        startTest
        endTest
        Log
        flush

        startTest and endTest methods are used to execute preconditions and post-conditions of a test case,
        while log method is used to log the status of each test step onto the resultant HTML report.
        Flush method is used to erase any previous data on the report and create a new report.

        Test Status can be any of the following values:

        PASS
        FAIL
        SKIP
        INFO
        Syntax:

        reports.endTest();
        test.log(LogStatus.PASS,”Test Passed”);
        test.log(LogStatus.FAIL,”Test Failed”);
        test.log(LogStatus.SKIP,”Test Skipped”);
        test.log(LogStatus.INFO,”Test Info”);

        Log method takes in two parameters, the first parameter is the test status and the second parameter is the message to
        be printed onto the resultant report.
*/

