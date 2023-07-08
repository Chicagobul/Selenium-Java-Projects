package SpecBuilder;

import Pojo.Location;
import Pojo.addPlace;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest
    //Serialization Process
{
    public static void main (String[] args)
    {
        addPlace ad = new addPlace();
        ad.setAccuracy(50);
        ad.setAddress("29, side layout, cohen 09");
        ad.setLanguage("French-IN");
        ad.setPhone_number("(+91) 983 893 3937");
        ad.setWebsite("http://google.com");
        ad.setName("Frontline house");

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        ad.setTypes(myList);

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);

        ad.setLocation(l);

        RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
        .addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        RequestSpecification res = given().spec(requestSpec)
        .body(ad);
        Response response = res.when().post("/maps/api/place/add/json")
        .then().spec(responseSpec).extract().response();

        String responseString = response.asString();
        System.out.println(responseString);
    }
}
