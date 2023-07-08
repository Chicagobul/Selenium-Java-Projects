import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.*;

public class AddAttachment extends AddComment
{
    public static void main(String[] args)
    {
        RestAssured.baseURI = "http://localhost:8080";
        SessionFilter sf1 = new SessionFilter();
        String response = given().header("Content-Type", "application/json").body("{ \"username\": \"root\", \"password\": \"root\" }")
                .log().all().filter(sf1).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();

        //Add attachment
        given().header("X-Atlassian-Token", "no-check").filter(sf1).pathParam("id", "10103")
        .multiPart("file", new File("C:\\Users\\RAHUL\\IdeaProjects\\Jira API section 8\\jira.txt"))

                //to upload a file in rest assured we use multiPart()

                /*Rest assured not allowed to use .body and .multiPart at the same time. And when we use
                 .multiPart, the content-type automatically set to "multipart/form-data". If we want to send
                 JSON we need to set the content-type as "application/json". But "application/json" does
                 not allow the multipart file to send on the request. So If we want to send some JSON
                 data along with multipart file, Convert the JSON key, values as MAP and send it with
                 .formParams, send multipart file in .multipart function.*/

                .when().post("/rest/api/2/issue/{id}/attachments")
        .then().log().all().assertThat().statusCode(200);

        //Get issue
        String issueDetails = given().filter(sf1).pathParam("id", "10103").queryParam("fields", "comment").log().all()
        .when().get("/rest/api/2/issue/{id}").then().log().all().extract().response().asString();
        System.out.println(issueDetails);

        JsonPath jsonPath = new JsonPath(issueDetails);
        int commentCount = jsonPath.getInt("fields.comment.comments.size()");
        for (int i=0; i<commentCount; i++)
        {
            String commentIDIssue = jsonPath.get("fields.comment.comments["+i+"].id").toString();
            if (commentIDIssue.equalsIgnoreCase(commentID))
            {
               String message = jsonPath.get("fields.comment.comments["+i+"].body").toString();
               System.out.println(message);
            }
        }
    }
}

//When you want to send a file or attachment to a defect in Rest Assured use multiPart in given(), it is used in key value pair
//If a file is at project level then you can also give the file name directly
//If you want to handel the Https certification use this after .given() -> .relaxedHTTPSValidation()