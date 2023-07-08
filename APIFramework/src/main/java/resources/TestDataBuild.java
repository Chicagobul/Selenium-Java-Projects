package resources;

import pojo.Location;
import pojo.addPlace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataBuild
{
    public addPlace addPlacePayload(String name, String language, String address)
    {
        addPlace ad = new addPlace();
        ad.setAccuracy(50);
        ad.setAddress(address);
        ad.setLanguage(language);
        ad.setPhone_number("(+91) 983 893 3937");
        ad.setWebsite("http://google.com");
        ad.setName(name);

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        ad.setTypes(myList);

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);

        ad.setLocation(l);
        return ad;
    }

    public String deletePlacePayload(String placeID)
    {
        return "{\"place_id\":\""+placeID+"\"}";
    }
}
