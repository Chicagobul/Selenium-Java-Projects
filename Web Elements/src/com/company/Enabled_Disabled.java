package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Enabled_Disabled
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com/");
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //-->Here we are using this assert validation it is a method provided by TestNG framework, .assertFalse expects
        // result as false if it gets false it passes the step else it fails and the execution of our script stops at that step only
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("Is enabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }


        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        /*Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        //s.selectByValue("USD");
        //s.selectByIndex(4);
        s.selectByVisibleText("USD");*/
        driver.findElement(By.id("divpaxinfo")).click();
        Select s=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.selectByValue("4");
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
        //-->Here .assertEquals matches the actual result with the expected result if both matched it passes the step
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    }
}
