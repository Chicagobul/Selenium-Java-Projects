package org.example;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse
{
    public static void main(String[] args)
    {
        JsonPath jsonPath = new JsonPath(payload.CoursePrice());

        //Print no. of courses returned by API
        int count = jsonPath.getInt("courses.size()");
        System.out.println(count);

        //Print purchase amt
        int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        //Print title of first course
        String titleFirstCourse = jsonPath.getString("courses[1].title");
        System.out.println(titleFirstCourse);

        //Print all courses title and there prices
        for (int i = 0; i < count; i++)
        {
            System.out.println(jsonPath.get("courses[" + i + "].title"));
            System.out.println(jsonPath.get("courses[" + i + "].price"));
        }

        //Print no of copies sold by RPA Course
        for (int i = 0; i < count; i++)
        {
            String courseTitles = jsonPath.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA"))
            {
                int copies = jsonPath.get("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }

    }
}
