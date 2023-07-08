package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Customised_Xpath
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        /*driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Email address");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Password");
        driver.findElement(By.xpath("//*[@name='login']")).click();*/

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Email address");
        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("Password");
        driver.findElement(By.cssSelector("[name='login']")).click();
        //-->In CSS if you don't want to use the tagname and if it want to be anything just leave it blank like below
        // [attribute='value']

        /*To form customised CSS:
        Syntax -->1) tagname[attribute='value']
                  2) tagname#id (here you can skip tagname also i.e just #id)
                  3) tagname.classname

        To form customised Xpath:
        Syntax --> //tagname[@attribute='value']
        For Password text field: //input[@id='pass']
        For login button: //*[@name='login']
        -->Here '*' refers to any tag that contains name='login'
        For Email text field: //*[@type='text']

        ->If a component on the web page contains only one attribute which is having alpha numeric value that keeps on
          changing so you can use these syntaxes:

          //tagname[contains(@attribute,'value')] - xpath
          tagname[attribute*='value'] - CSS
          tagname:contains("text of the element") - CSS

          Ex - html code:
          <input name="username123">

          xpath - //input[contains(@name,'username')]
          CSS - input[name*='username']


         */




    }
}
