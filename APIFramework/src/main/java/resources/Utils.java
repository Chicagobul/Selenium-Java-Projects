package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils
{
    public static RequestSpecification requestSpec;
    public RequestSpecification requestSpecification() throws IOException
    {
        if (requestSpec==null)
        {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            requestSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
            return requestSpec;
        }
        return requestSpec;
        //We use addFilter class to log all the details as it has diff methods(filters) to log such as  RequestLoggingFilter
        //Then we will log all the details in a file using logRequestTo method it is of print stream type so we will create an
        //obj of this class and will pass the name of the file in which we have to log the details(new file will be created with
        //this name)
        //We are checking the if condition as if we provide more than one data-set in our feature file then it will override
        //the details in .txt file and will only show the info our the last data-set
        //Then we will return the request obj so that the next data-set will use this and add it's info in continuation of
        // the previous one
        //We made RequestSpecification requestSpec as static as if the loop runs for the second time the result of first run is
        //made available for second run else for the second time again requestSpec will be treated as null
    }

    public static String getGlobalValue(String key) throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\RAHUL\\IdeaProjects\\APIFramework\\src\\main\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key)
    {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
