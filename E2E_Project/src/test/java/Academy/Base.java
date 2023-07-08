package Academy;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

public class Base
{
    public WebDriver driver;
    public Properties prop;
    public WebDriver initialiseDriver() throws IOException
    {
        DesiredCapabilities handlSSL = new DesiredCapabilities();
        handlSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        handlSSL.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ChromeOptions ch = new ChromeOptions();
        ch.merge(handlSSL);
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\RAHUL\\IdeaProjects\\E2E_Project\\src\\main\\resources\\data.properties");
        // If you don't want to hard code thr file path you can use this : System.getProperty("user.dir")
        // It gives the path of current project then you can concatenate rest of the path using '+' such as :
        // System.getProperty("user.dir"+"\\src\\main\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver(ch);
        }
        else if (browserName.equals("Firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browserName.equals("IE"))
        {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void getScreenshot(String testMethodName, WebDriver driver) throws IOException
    {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\Test\\"+testMethodName+"screenshot.png"));
        // If we have multiple errors in our code so we can't store those screenshots with same name hence
        // we have concatenated the name of the failed test with screenshot.png

        // To run in headless mode use this:
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");
        // driver = new ChromeDriver(options);
        // in headless mode the browser doesn't open
    }
}
