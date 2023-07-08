package com.company;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main
{

    public static void main(String[] args) throws MalformedURLException
    {
        //-->Code to run our script on remote machine
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        WebDriver driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), dc);
        //remote webdriver object accepts 2 arguments one is the URL which is there in cmd of our local machine(hub)
        // and the other one is the DesiredCapabilities object that we have created above
        // at last write /wd/hub (you can use localhost in place of ip address)
        // wd - webdriver
        
        driver.get("https://google.com/");
    }
}
