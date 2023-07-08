package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class Screenshort
{

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/32238/pak-vs-rsa-3rd-t20i-south-africa-tour-of-pakistan-2021");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //-->Convert web driver object to TakesScreenshot then Call getScreenshotAs method to create image file
        FileUtils.copyFile(src, new File("D:\\screenshort.png"));
        //-->copying the  screenshot to desired location in our local machine using copyFile method

    }
}
