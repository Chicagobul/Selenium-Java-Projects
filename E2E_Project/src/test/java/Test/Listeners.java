package Test;

import Academy.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener
{
    Base b = new Base();

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult result)
    {
        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();
        // To get the screenshot name
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver")
                    .get(result.getInstance());
            //We can use this to get access to fields of any class using testNG listeners, here we are
            //taking instance of "driver" field as we are taking instance of driver hence we need to cast this
            //into webdriver
            //We are using this so that our code can take screenshots even in parallel execution
        } catch (Exception e)
        {

        }
        try
        {
            b.getScreenshot(testMethodName, driver);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //To capture the details of the failed test case we need access to the driver of that test case and send
    //that driver as an input to screenshot method

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
