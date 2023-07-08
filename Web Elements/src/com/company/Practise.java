package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practise
{

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
        {
            System.out.println("Is disabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        Select s=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.selectByValue("4");
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
        //-->Here .assertEquals matches the actual result with the expected result if both matched it passes the step
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

    }
}
