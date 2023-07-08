package com.company;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Day2 extends Day3
{
    @Test
    public void Day2demo()
    {
        System.out.println("second class");
        Assert.assertTrue(false);
    }

    @Test(dataProvider = "getdata")
    public void Mobilesignout(String username, String password)
    {
        System.out.println("Mobile SignOut");
        System.out.println(username);
        System.out.println(password);
    }

    @BeforeTest
    public void firstexecution()
    {
        System.out.println("will execute first");
    }

    @BeforeSuite
    public void BFSuite()
    {
        System.out.println("i am no. 1");
    }

    @Test(dependsOnMethods = {"Day2demo"})
    public void API()
    {
        System.out.println("api login");
    }

    @DataProvider
    public Object[][] getdata()
    {
        Object[][] data = new Object[3][2];
        data[0][0] = "first set username";
        data[0][1] = "first password";
        data[1][0] = "second set username";
        data[1][1] = "second password";
        data[2][0] = "third set username";
        data[2][1] = "third password";
        return data;

    }

    @Test
    public void openbrowser() throws IOException
    {
        applicationlogin();
    }
}

//-->We can also exclude any method in our testng xml file by using the exclude tag
// <exclude name="Mobile.*"/> - This excludes all the testcases which starts with Mobile keyword at one shot
// You can also execute all the testcases in one package at one shot by following xml code :
// <packages>
//      <package name="com.company"/>
// </packages>
// TestNG executes the methods in a class as per alphabetical order
// We can run some specific methods from diff classes by using groups tag, use groups and then give some name to it
// and make a seprate xml file as testng2
// You can also use exclude tag inside the run tag with the groups to exclude those cases
// In above code we use dependsOnMethods annotation with this the Day2demo will execute before API that means it is dependent
// on Day2demo it will only run when Day2demo has executed(acc to testNG alphabetical order API would have executed first)
// We can pass more than one method name in dependsOnMethods annotation as for ex. @Test(dependsOnMethods={"Day2demo","XYZ"})
// To skip any case from execution use this : @Test(enabled=false)
// and if you set enabled=true it gets 'ON' again
// @Test(timeOut=4000) : to make any test case wait for 4000 milli sec
// To run all the test cases parallelly use this code at suite level :
// <suite name="All Test Suite" parallel="tests" thread-count="2">
//-->Here thread-count="2" means to run 2 test cases parallelly
//At class level to make classes to run parallelly : <test name="Test Classes" parallel="classes" thread-count="2">