package com.company;
//-->ITestListener is an interface which implements all the TestNG listeners

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{
    @Override
    public void onTestSuccess(ITestResult result)
    {

    }

    @Override
    public void onTestFailure(ITestResult result)
    {
       System.out.println("I failed the execution :"+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {

    }

    @Override
    public void onStart(ITestContext context)
    {

    }

    @Override
    public void onFinish(ITestContext context)
    {

    }

    @Override
    public void onTestStart(ITestResult result)
    {

    }
}
