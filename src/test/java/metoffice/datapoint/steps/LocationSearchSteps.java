package metoffice.datapoint.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class LocationSearchSteps {
    private String SITE_LIST_SEARCH = "http://datapoint.metoffice.gov.uk/public/data/";
    private Response response;

    @Step
    public void searchSiteListByLocation(String code){
        response = SerenityRest.when().get(SITE_LIST_SEARCH + code + "?key=e7fbd591-bf66-4247-b9b1-6c52030ba8a5");
    }
}
