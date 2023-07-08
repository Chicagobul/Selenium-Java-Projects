package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com/");
        /*Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        //s.selectByValue("USD");
        //s.selectByIndex(4);
        s.selectByVisibleText("USD");*/
        driver.findElement(By.id("divpaxinfo")).click();
        Select s=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.selectByValue("4");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //->When ever you see select tag for a dropdown that means it is static dropdown

    }
}
