package ho.qat.seo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LongerSixMonthsPage extends PageObject {

    WebElementFacade jobTypeToSelect;

    @FindBy(css = "#current-question > button")
    private WebElementFacade nextStepButton;


    public void selectJobType(String type){
        String selector = String.join("","input[value='", type.toLowerCase(), "']");
        jobTypeToSelect = find(By.cssSelector(selector));
        clickOn(jobTypeToSelect);
    }

    public void clickNextStepButton(){
        clickOn(nextStepButton);
    }

}
