package Pojo;

//We have created a pojo class for GetCourse and a separate pojo class for Courses as they both are separate json's
//webAutomation, api and moblie are arrays containing key & value pairs so we again have to create 3 diff pojo classes for them
//As all the three are arrays so they have list of items in it so we will wrap webAutomation return type into List

import java.util.List;

public class Courses
{
    private List<webAutomation> webAutomation;
    private List<api> api;
    private List<mobile> mobile;

    public List<Pojo.webAutomation> getWebAutomation()
    {
        return webAutomation;
    }

    public void setWebAutomation(List<Pojo.webAutomation> webAutomation)
    {
        this.webAutomation = webAutomation;
    }

    public List<Pojo.api> getApi()
    {
        return api;
    }

    public void setApi(List<Pojo.api> api)
    {
        this.api = api;
    }

    public List<Pojo.mobile> getMobile()
    {
        return mobile;
    }

    public void setMobile(List<Pojo.mobile> mobile)
    {
        this.mobile = mobile;
    }
}
