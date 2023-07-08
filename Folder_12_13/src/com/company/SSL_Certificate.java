package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL_Certificate
{

    public static void main(String[] args)
    {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //-->Desired capabilities class is used to modify the properties of the web driver
        // It contains a set of key-value pairs to change individual properties of web driver
        // Here are using DesiredCapabilities.chrome(); as we are customising the properties for chrome browser
        //dc.acceptInsecureCerts();
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ChromeOptions ch = new ChromeOptions();
        //-->Chrome Options class is used to control the properties of Chrome Driver
        ch.merge(dc);
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(ch);
        driver.manage().window().maximize();
        // To maximize our window
        driver.manage().deleteAllCookies();
        // To delete all the cookies
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/32238/pak-vs-rsa-3rd-t20i-south-africa-tour-of-pakistan-2021");


    }
}
