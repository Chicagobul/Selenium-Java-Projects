package stepDefinitions;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks
{
    @Before("@DeletePlace")
    public void beforeScenario() throws IOException
    {
        //write a code that will give you place id
        //execute this code only when place id is null as the addPlaceAPI tc shouldn't run twice every time
        //this code should be used only when deletePlaceAPI is being executed independently of addPlaceAPI

        stepDefinition sd = new stepDefinition();
        if (sd.place_id == null)
        {
            sd.add_place_payload_with("Singh", "Hindi", "India");
            sd.user_calls_with_post_http_request("AddPlaceAPI", "POST");
            sd.verify_place_id_created_maps_to_using("Singh", "POST");
        }
    }
}

//We have created this java class to introduce the Hooks feature of cucumber, it is used to give pre and post conditions to our
//testcase's for example in this we are giving a pre condition to give place id for our deletePlaceAPI scenario so that we can
//run this testcase independently of addPlaceAPI scenario