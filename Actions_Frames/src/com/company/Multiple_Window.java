package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Multiple_Window

{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup");
        driver.findElement(By.xpath("//a[text()='Help']")).click();
        System.out.println(driver.getTitle());
        Set<String> id = driver.getWindowHandles();
        //-->Here getWindowHandles() gives the id's of all the windows that are opened
        Iterator<String> it = id.iterator();
        String parentid = it.next();
        //-->This is used to move to the first window i.e the parent window
        String childid = it.next();
        driver.switchTo().window(childid);
        //-->This switches the control from parent window to child window
        System.out.println(driver.getTitle());

    }
}
