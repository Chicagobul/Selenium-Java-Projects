package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame

{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        //driver.findElement(By.id("draggable")).click();
        Actions a = new Actions(driver);
        WebElement s = driver.findElement(By.id("draggable"));
        WebElement t = driver.findElement(By.id("droppable"));
        a.dragAndDrop(s, t).build().perform();
        //-->It is used to drag and drop a WebElement from one place to other
        driver.switchTo().defaultContent();
        //-->Here this step is used to shift the control back to the parent window

    }
}
