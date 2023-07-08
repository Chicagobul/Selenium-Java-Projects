package org.example;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson
{
    @Test(dataProvider = "getData")
    public void addBook(String isbn, String aisle)
    {
        RestAssured.baseURI = "http://216.10.245.166";
        String resp = given().header("Content-Type", "application/json")
        .body(payload.Addbook(isbn, aisle)) //sending parameters to payload from test(payload class)
        .when().post("/Library/Addbook.php")
        .then().log().all().assertThat().statusCode(200)
        .extract().response().asString();

        JsonPath js = new JsonPath(resp);
        String id = js.getString("ID");
        System.out.println(id);
    }

    @DataProvider
    public Object[][] getData()
    {
        return new Object[][]  {{"awse","1258"}, {"sedr","1236"}, {"ftgy","2569"}};
    }
}

/*If our payload is static(always remain same) then we can also take this from external json file and pass the respective path
of the file in body tag :
.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Rahul\\Documents\\xyz.json"))))

->We use Files method to convert the content of the file to Bytes then into String
 */

