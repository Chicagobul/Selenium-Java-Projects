package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Implicit_Explicit_Wait {

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
        driver.findElement(By.id("H-destination")).sendKeys("nyc");
        driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);
        driver.findElement(By.id("H-fromDate")).sendKeys(Keys.ENTER);

        WebDriverWait d=new WebDriverWait(driver,20);
        d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='resultsContainer']/section/article[1]")));
        //Thread.sleep(5000L);

        driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();

        //Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
        //Here we are passing driver obj and telling FluentWait that it is of WebDriver type

                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver webDriver)
            {
                if(driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).isDisplayed())
                {
                    return driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]"));
                }
                else
                    {
                        return null;
                    }
            }
        });

    }
}
