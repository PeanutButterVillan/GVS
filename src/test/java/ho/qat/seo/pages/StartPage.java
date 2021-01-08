package ho.qat.seo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.govuk.uk/check-uk-visa")
public class StartPage extends PageObject {

        @FindBy(css = "#get-started > a")
        private WebElementFacade startNowButton;

        public void clickStartNow(){
            clickOn(startNowButton);
        }

}
