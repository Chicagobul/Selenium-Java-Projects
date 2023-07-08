package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dynamic_Dropdown
{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();

        // -->Here we are using this as our script will get confused as to which Bhopal to choose as it is present in
        // the 'To' dropdown also so we have assigned it number [2] to remove this confusion : (xpath)[2]

        //-->If you don't want ot use the above xpath with the index no. you can use a diff. method of parent child
        // relationship such as : //div[@id='#ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
        // first write the xpath for parent then give a space and then xpath for child

        driver.findElement(By.xpath("//div[@id='#ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();

    }
}
