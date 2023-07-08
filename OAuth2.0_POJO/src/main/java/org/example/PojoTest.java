package org.example;

import Pojo.GetCourse;
import Pojo.api;
import Pojo.webAutomation;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoTest
    //Deserialization Process
{
    public static void main( String[] args )
    {
        /*System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow");
        driver.findElement(By.xpath("//div[contains(@class, 'pQ0lne')]/ul/li")).click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();*/

        String[] courseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};
        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWgPw5jsAfLjVHM5WGsY7u4tPxP094wUp2XLGY3Ldyq6TB8KD-KNK_oAv3OEO-Q15Q&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
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

        //For deserialization we will convert our json, for this we will wrap it into our pojo class as it is easy to parse and
        //extract response (json/xml) values if they are wrapped as java object
        //Response what we get from GetCourse class is the obj of that class so we will change the return type to GetCourse obj
        //In rest-assured we have to tell it that in what format it has to scan the output so that's why we will have to use :
        //.expect().defaultParser(Parser.JSON), if in Content-Type we will give application/json so we can skip this step

        GetCourse response = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
        .when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
        System.out.println(response.getLinkedIn());
        System.out.println(response.getInstructor());
        System.out.println(response.getCourses().getApi().get(1).getCourseTitle());

        List<api> apiCourse = response.getCourses().getApi();
        for (int i=0; i<apiCourse.size(); i++)
        {
            if(apiCourse.get(i).getCourseTitle().equalsIgnoreCase("SoapUi Webservices testing"))
            {
                System.out.println(apiCourse.get(i).getPrice());
            }
        }

        //Get the course names of webAutomation
        ArrayList<String> a = new ArrayList<String>();
        //Here we are using array list in place of array as in array we have to declare the size in the starting only but with
        //array list we can inc. the size on runtime by using .add() method
        List<webAutomation> w = response.getCourses().getWebAutomation();
        for (int j=0; j<w.size(); j++)
        {
            a.add(w.get(j).getCourseTitle());
        }

        List<String> expectedList = Arrays.asList(courseTitles);
        //Here we are converting our array which we have declared at the starting into array list
        Assert.assertTrue(a.equals(expectedList));
    }
}
