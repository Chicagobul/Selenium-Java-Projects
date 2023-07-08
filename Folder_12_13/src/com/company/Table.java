package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table
{

    public static void main(String[] args)
    {
        int sum=0;
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/32238/pak-vs-rsa-3rd-t20i-south-africa-tour-of-pakistan-2021");
        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        //int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
        //-->This is the css selector to reach the nth child directly from the parent

        for (int i=0; i<count-2; i++)
        // We are doing count-2 so that the loop doesn't traverse to ths last 2 lines
        {
            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int intvalue = Integer.parseInt(value);
            sum = sum+intvalue;
        }

        System.out.println("Without Extras:"+" "+sum);
        String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extrasvalue = Integer.parseInt(extras);
        int TotalSum = sum+extrasvalue;
        System.out.println("Total Score:"+" "+TotalSum);
        System.out.println("Actual Score:"+" "+driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());


    }
}
