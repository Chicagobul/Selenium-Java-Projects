import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddComment
{
    public static String commentID;
    public static void main(String[] args)
    {
        RestAssured.baseURI = "http://localhost:8080";


        SessionFilter sf = new SessionFilter();

        // Session filter : A session filter can be used to record the session id returned from the server as
        // well as automatically apply this session id in subsequent requests.
        // To use this use filter before when()

        String response = given().header("Content-Type", "application/json")
                .body("{ \"username\": \"root\", \"password\": \"root\" }")
        .log().all().filter(sf).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();


        String addCommentResponse = given().pathParam("id", "10103").log().all()
                .header("Content-Type", "application/json")
                .header("Cookie", "JSESSIONID=CE8759DBAE14047DF076803C6DA19115")
                .body("{\n" +
                "    \"body\": \"This is a comment that only administrators can see.\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}").filter(sf).when().post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201)
                .extract().response().asString();

        // If you want to send anything at run time in resource give it in {} brackets like this : rest/api/2/issue/{id}/comment

        JsonPath js = new JsonPath(addCommentResponse);
        commentID = js.getString("id");
    }
}
