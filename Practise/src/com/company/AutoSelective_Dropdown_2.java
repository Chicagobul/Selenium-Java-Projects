package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSelective_Dropdown_2
{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ksrtc.in/");
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("beng");
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        // Creating the JavascriptExecutor interface object by Type casting
        // Javascript DOM can extract hidden elements in the web page we use this as selenium can't find the hidden
        // elements and to execute Javascript in selenium we do this through JavascriptExecutor interface

        String script = "return document.getElementById(\"fromPlaceName\").value;";
        // Here we use return as in javascript we use this to retrieve value, here it will take the value and assign it to
        // string script
        // We can't use double quotes inside double quotes in java that's why we use forward slash
        // We use 2 semicolons the first one as it is a javascript code and the 2nd one as this whole thing is considered
        // as a string so this is for java code execution in this IDE without any error
        // You can also run this in the console and check : document.getElementById("fromPlaceName").value;

        String text = (String) js.executeScript(script);
        // To execute our java script we use js.executeScript method and (String) is used to cast the result in string
        System.out.println(text);

        int i=0;
        while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT"))
        {
            i++;
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
            text = (String) js.executeScript(script);
            System.out.println(text);
            if(i>7)
            {
                break;
            }
        }

        if (i>7)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Element found");
        }
    }
}
