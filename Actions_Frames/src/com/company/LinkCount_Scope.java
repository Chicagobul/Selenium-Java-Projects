package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class LinkCount_Scope

{

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));

        //-->Here we are limiting the web driver scope to footer section only
        System.out.println(footerdriver.findElements(By.tagName("a")).size());
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        for (int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++)
        {
            String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            //-->Here Keys.chord() method helps to press multiple keys simultaneously so we are pressing ctrl and enter
            // keys to open the links in a new tab(shortcut to open links in a new tab)
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
            Thread.sleep(5000);

            Set<String> s = driver.getWindowHandles();
            Iterator<String> it = s.iterator();
            while (it.hasNext())
            {
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
            }
        }


    }
}
