package org.example;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class App

/*validate if Add Place API is working as expected
Rest API works on three things :
given : all input details
when : Submit the api - resource and http response
then : validate the response
*/
//Add place -> Update place with new address -> get place to validate if new address is present in response
{
    public static void main( String[] args )
    {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
        .body(payload.AddPlace())
        .when().post("/maps/api/place/add/json")
        .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
        .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        //.extract().response().asString() - it is used to extract the response and store it in a string
        //.log.all() - it is used to log the output in console

        System.out.println(response);

        JsonPath js = new JsonPath(response);
        //it is used for json parsing, it takes input as string and convert it into json

        String placeId = js.getString("place_id");
        System.out.println(placeId);

        //Update Place
        String newAddress = "Summer Walk, Africa";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
        .body("{\n" +
                "\"place_id\":\""+placeId+"\",\n" +
                "\"address\":\""+newAddress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}")
         .when().put("/maps/api/place/update/json")
         .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //Get Place
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
        .queryParam("place_id", placeId)
        .when().get("/maps/api/place/get/json")
        .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js2 = new JsonPath(getPlaceResponse);
        String actualAddress = js2.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAddress);
    }
}
