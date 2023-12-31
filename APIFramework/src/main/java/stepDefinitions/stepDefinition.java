package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Location;
import pojo.addPlace;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class stepDefinition extends Utils
{
    RequestSpecification res;
    ResponseSpecification responseSpec;
    Response response;
    public static String place_id;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException
    {
        res = given().spec(requestSpecification())
                .body(data.addPlacePayload(name, language, address));
    }
    @When("User calls {string} with {string} http request")
    public void user_calls_with_post_http_request(String resource, String method)
    {
        //constructor of APIResources enum will be called with value of resource which you pass
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        responseSpec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        if(method.equalsIgnoreCase("POST"))
        {
            response = res.when().post(resourceAPI.getResource());
        }
        else if(method.equalsIgnoreCase("GET"))
        {
            response = res.when().get(resourceAPI.getResource());
        }
    }
    @Then("The API call got success with Status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1)
    {
        assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getStatusCode());
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue)
    {
        assertEquals(getJsonPath(response, keyValue), expectedValue);
    }
    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException
    {
        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_post_http_request(resource, "GET");
        String actualName = getJsonPath(response, "name");
        assertEquals(actualName, expectedName);
    }

    @Given("DeletePlace Payload")
    public void delete_place_payload() throws IOException
    {
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }

}
