package com.company;

import org.testng.annotations.*;

public class Day1
{
    @AfterSuite
    public void AFSuite()
    {
        System.out.println("i am at last no.");
    }

    @AfterTest
    public void lastexecution()
    {
        System.out.println("will execute last");
    }

    @Test(groups = {"Smoke"})
    public void Demo()
    {
        System.out.println("hello");
    }

    @Test
    public void SecondTest()
    {
        System.out.println("Bye");
    }

    @BeforeClass
    public void BeforeClass()
    {
        System.out.println("before executing any method in the class");
    }

    @AfterClass
    public void AfterClass()
    {
        System.out.println("after executing any method in the class");
    }
}
