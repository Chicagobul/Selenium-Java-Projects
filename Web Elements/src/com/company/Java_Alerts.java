package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java_Alerts
{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
        driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();
        System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().sendKeys("Good");
        //--> alert should only be used when you are not able to get the html code for that alert or button as it is part of java
        // and not the web else you can do it simply by driver.findElement
        driver.switchTo().alert().accept();
        //-->This will switch the driver obj control from web page to java alert
        // .accept() will click on ok button in the popup, it is used for positive scenarios such as ok, yes, done etc
        // else use .dismiss()
    }
}
