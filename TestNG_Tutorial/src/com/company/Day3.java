package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Day3
{
    WebDriver driver = null;
    @Parameters({"URL"})
    //here we are taking value of url from xml file (testng.xml)
    @Test
    public void WebLogin(String urlname)
    {
        System.out.println("weblogin car");
        System.out.println(urlname);
    }

    @Test(groups = {"Smoke"})
    public void MobileLogin()
    {
        System.out.println("mobilelogin car");
    }

    @BeforeMethod
    public void BeforeEveryMethod()
    {
        System.out.println("will execute before every method in Day3 class");
    }

    @AfterMethod
    public void AfterEveryMethod()
    {
        System.out.println("will execute after every method in Day3 class");
    }

    @Test
    public void applicationlogin() throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\RAHUL\\IdeaProjects\\TestNG_Tutorial\\src\\com\\company\\datadriven.properties");
        prop.load(fis);
        System.out.println(prop.getProperty("username"));

        if (prop.getProperty("browser").contains("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get(prop.getProperty("url"));
        System.out.println(prop.setProperty("browser", "firefox"));
        System.out.println(prop.getProperty("browser"));
        FileOutputStream fos = new FileOutputStream("C:\\Users\\RAHUL\\IdeaProjects\\TestNG_Tutorial\\src\\com\\company\\datadriven.properties");
        prop.store(fos, null);
    }
}
