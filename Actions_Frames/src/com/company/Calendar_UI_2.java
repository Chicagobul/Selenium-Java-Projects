package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Calendar_UI_2

{

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.xpath("//input[@id='travel_date']")).click();
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April"))
        //-->Here we use negation '!' as it reverses the result when the result is false it makes it true and vice-versa
        {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }
        List<WebElement> date = driver.findElements(By.className("day"));
        int count = driver.findElements(By.className("day")).size();

        for (int i=0; i<count; i++)
        {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("23"))
            {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }


    }


}
