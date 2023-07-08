package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Mouse_Hover {

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //-->It is used to maximize the output window
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        //-->Actions class is used to handel mouse and keyboard events with this after performing our action we have to
        // use build and perform methods to complete our execution with Actions
        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
                .doubleClick().build().perform();
        //-->Here keyDown is used to hold the Shift key to write in bold then double click is used to select what we have written
        a.moveToElement(move).contextClick().build().perform();
        //-->Here moveToElement is used to move the cursor to that web element and contextClick is used to right click on that element
    }
}
