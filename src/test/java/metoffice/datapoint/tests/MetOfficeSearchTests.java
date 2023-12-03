package metoffice.datapoint.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class MetOfficeSearchTests {
    @Test
    public void verifyThatWeCanFindWindSpeedUsingTheLocationCroydon(){

        int s, i;
        JsonPath j;
        String state, name;
        String description = "";
        String locationCode= "";
        Response response;

        response = given().when().get("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=e7fbd591-bf66-4247-b9b1-6c52030ba8a5");

        j = new JsonPath(response.asString());

        s = j.getInt("Locations.Location.size()");
        for(i = 0; i < s; i++) {
            state = j.getString("Locations.Location["+i+"].name");

            if(state.equalsIgnoreCase("Croydon")) {
                locationCode = j.getString("Locations.Location["+i+"].id");
                break;
            }
        }

        name = given().when().get("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + locationCode + "?res=daily&key=e7fbd591-bf66-4247-b9b1-6c52030ba8a5")
                .andReturn().then().contentType(ContentType.JSON).extract().path("SiteRep.DV.Location.name");

        assertEquals("Invalid location name", "CROYDON", name);

        response = given().when().get("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/324152?res=daily&key=e7fbd591-bf66-4247-b9b1-6c52030ba8a5");
        j = new JsonPath(response.asString());

        s = j.getInt("SiteRep.Wx.Param.size()");
        for(i = 0; i < s; i++) {
            state = j.getString("SiteRep.Wx.Param["+i+"].name");

            if(state.equalsIgnoreCase("S")) {
                description = j.getString("SiteRep.Wx.Param["+i+"].$");
                break;
            }
        }

        assertEquals("Invalid description", "Wind Speed", description);

    }
}
