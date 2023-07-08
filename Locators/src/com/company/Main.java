package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*driver.get("https://facebook.com");
        driver.findElement(By.id("email")).sendKeys("Email id entered");
        driver.findElement(By.name("pass")).sendKeys("Password entered");
        driver.findElement(By.linkText("Forgotten password?")).click();*/

        driver.get("https://login.salesforce.com/");
        /*driver.findElement(By.id("username")).sendKeys("Email id entered");
        driver.findElement(By.name("pw")).sendKeys("Password entered");

        // By.className should not have spaces it will give error msg --> Compound class names not permitted, to use it
        // just remove the spaces and use dot(.)
        //driver.findElement(By.id("Login")).click();

        driver.findElement(By.xpath("//*[@id='Login']")).click();
        //-->In xpath convert the double quotes into single as in java double quotes inside double quotes is a syntax
        // error*/

        driver.findElement(By.cssSelector("#username")).sendKeys("Email address");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password");
        driver.findElement(By.id("Login")).click();
        System.out.println(driver.findElement(By.id("error")).getText());
    }
}
