package Serialization;

import Pojo.Location;
import Pojo.addPlace;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class serializeTest
    //Serialization Process - java obj into json
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

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String res = given().log().all().queryParam("key", "qaclick123")
                //converting java obj into json
        .body(ad)
        .when().post("/maps/api/place/add/json")
        .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(res);
    }
}
