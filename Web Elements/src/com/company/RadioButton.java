package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton
{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://echoecho.com/htmlforms10.htm");
        //driver.findElement(By.xpath("//input[@value='Butter']")).click();
        //System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).size());
        //-->Here we are trying to find that how many radio buttons are there with same name i.e group1 so we use
        // findElements method instead of findElement

        int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
        for (int i=0; i<count; i++)
        {
            //driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
            //-->Here .get(i) will go to the third radio button according to the for loop and then we will click on it

            String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
            if (text.equals("Cheese"))
            {
                driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
            }
            //-->Here .getAttribute will get the value of the 'value' attribute from the html code, if it is Cheese we
            // will click on it

            //--> With the first method the script will click on all the 3 radio buttons but with the third method it
            // will only click on the Cheese radiobutton and we are doing this without using @value attribute in the xpath
        }

    }
}
