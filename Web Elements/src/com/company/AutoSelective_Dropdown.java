package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSelective_Dropdown
{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://makemytrip.com/");
        driver.findElement(By.xpath("//*[@id='fromCity']")).click();
        WebElement s=driver.findElement(By.xpath("//*[contains(@class, 'react-autosuggest__input')]"));
        s.sendKeys("BOM");
        Thread.sleep(3000);
        s.sendKeys(Keys.ARROW_DOWN);
        s.sendKeys(Keys.ENTER);
        WebElement p=driver.findElement(By.xpath("//*[contains(@placeholder, 'To')]"));
        p.sendKeys("BLR");
        Thread.sleep(3000);
        p.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
    }
}
