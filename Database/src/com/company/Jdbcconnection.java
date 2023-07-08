package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class Jdbcconnection
{

    public static void main(String[] args) throws SQLException
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qadb","root","12345");
        //3306 is the default port for Mysql
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Employeeinfo where Id = 2");
        while (rs.next())
        {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://login.salesforce.com/?locale=in");
            driver.findElement(By.xpath("//*[@id='username']")).sendKeys(rs.getString("Name"));
            driver.findElement(By.xpath("//*[@id='password']")).sendKeys(rs.getString("Password"));
            driver.findElement(By.xpath("//*[@id='Login']")).click();
        }
    }
}
