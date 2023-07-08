import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileDownload
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        String downloadPath = System.getProperty("user.dir");
        // To get the location of this java file i.e FileDownload

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

        // These are the steps to download something from chrome given in chrome official doc
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        // This step tells that this is our default directory to download the file

        ChromeOptions ch = new ChromeOptions();
        ch.setExperimentalOption("prefs", "chromePrefs");
        // setExperimentalOption is used to test particular feature of chrome driver before it gets released from
        // Chrome Developers

        WebDriver driver = new ChromeDriver(ch);
        driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.xpath("//*[@id='dropzoneInput-label']")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("D:\\fileupload.exe");
        // It is used to call/execute .exe file

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert Now!']")));
        driver.findElement(By.xpath("//button[text()='Convert Now!']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Download']")));
        driver.findElement(By.xpath("//a[text()='Download']")).click();
        Thread.sleep(5000);

        File f = new File(downloadPath+ "/Result.zip");
        // Creating the file class obj to pass the file path as an argument
        // In java we use forward slash if we want to concatenate with another string path

        if (f.exists())
        {
            Assert.assertTrue(f.exists());
            System.out.println("Found the file");
            if(f.delete())
            {
                System.out.println("File has been deleted");
            }
        }
        else
        {
            System.out.println("File not found");
        }

    }
}
