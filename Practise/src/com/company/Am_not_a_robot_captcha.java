package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Am_not_a_robot_captcha
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fantasycricket.dream11.com/IN/");
        int number = findFramenumber(driver,By.xpath("//*[@id='recaptcha-anchor']/div[5]"));
        driver.switchTo().frame(number);
        driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[5]")).click();
        driver.switchTo().defaultContent();

        int number1 = findFramenumber(driver,By.xpath("//*[@id='recaptcha-verify-button']"));
        driver.switchTo().frame(number1);
        driver.findElement(By.xpath("//*[@id='recaptcha-verify-button']")).click();

    }

    public static int findFramenumber(WebDriver driver, By by)
    {
        int i;
        int framecount = driver.findElements(By.tagName("iframe")).size();

        for (i=0; i<framecount; i++)
        {
            driver.switchTo().frame(i);
            int count = driver.findElements(by).size();

            if (count>0)
            {
                break;
            }
            else
            {
                System.out.println("Continue Looping");

            }
        }
        driver.switchTo().defaultContent();
        return i;
    }

}
