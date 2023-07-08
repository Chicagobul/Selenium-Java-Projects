import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class FileUpload
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://smallpdf.com/pdf-to-jpg");
        driver.findElement(By.xpath("//*[contains(@class,'l3tlg0-0')]")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("D:\\fileupload.exe");
        // It is used to call/execute .exe file


    }
}
