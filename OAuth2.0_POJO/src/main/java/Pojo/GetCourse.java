package Pojo;

//Here we have changed the return type of Courses from String to Courses (class name) as it is not a variable
// it itself is a json and it's output is coming from Courses.java class
//In getter and setter methods also we have placed Pojo.Courses in place of String

public class GetCourse
{
    private String url;
    private String services;
    private Courses Courses;
    private String expertise;
    private String instructor;
    private String linkedIn;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Pojo.Courses getCourses()
    {
        return Courses;
    }

    public void setCourses(Pojo.Courses courses)
    {
        this.Courses = courses;
    }

    public String getServices()
    {
        return services;
    }

    public void setServices(String services)
    {
        this.services = services;
    }

    public String getExpertise()
    {
        return expertise;
    }

    public void setExpertise(String expertise)
    {
        this.expertise = expertise;
    }

    public String getInstructor()
    {
        return instructor;
    }

    public void setInstructor(String instructor)
    {
        this.instructor = instructor;
    }

    public String getLinkedIn()
    {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn)
    {
        this.linkedIn = linkedIn;
    }
}
