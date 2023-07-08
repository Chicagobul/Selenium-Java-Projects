package org.example;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.*;

public class OAuthTest
{
    public static void main( String[] args )
    {
        /*System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow");
        driver.findElement(By.xpath("//div[contains(@class, 'pQ0lne')]/ul/li")).click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();*/

        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWhABiWnAkhb76Xw36NDjnu0iSZ4mUh50ZimdBPWR6NfPE3skebaqoxsIJaAb6Yjwg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";
        String partialcode = url.split("code=")[1];
        String code = partialcode.split("&scope=")[0];
        System.out.println(code);

        String accessTokenResponse = given().urlEncodingEnabled(false)
                //We use .urlEncodingEnabled method so that the compiler doesn't encode any special character in the code
        .queryParam("code", code)
        .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
        .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
        .queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
        .queryParam("grant_type","authorization_code")
        .when().post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath js = new JsonPath(accessTokenResponse);
        String accessToken = js.getString("access_token");


        String response = given().queryParam("access_token", accessToken).log().all()
        .when().get("https://rahulshettyacademy.com/getCourse.php").asString();
        System.out.println(response);
    }
}
