import org.testng.annotations.Test;

public class APITest
{
   @Test
    public void PostJira()
   {
      System.out.println("PostJira");
   }

   @Test
    public void DeleteTwitter()
   {
      System.out.println("DeleteTwitter");
   }

}

//-->If you have more than one xml file in you maven project then you can execute the one of your choice by using the
// profiles tag in that create one more tag profile and cut the code for surefire and paste the code in profile tag
// also give the id for every profile tag
// Give this command in cmd : mvn test -PRegression (here 'P' stands for profile)
// If you want to run a single class use this command in cmd : mvn -Dtest=APITest test
// If you want to use maven with testng add this in the dependecy code of surefire plugin, we do this with this plugin only
// <configuration>
//     <suiteXmlFiles>
//         <suiteXmlFile>testng.xml</suiteXmlFile>
//     </suiteXmlFiles>
// </configuration>
//If you want to use the above functionality give keyword 'Test' in class name like APITest
