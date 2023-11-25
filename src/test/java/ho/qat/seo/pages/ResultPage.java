package ho.qat.seo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"result-info\"]/div[2]/div/h2")
    WebElementFacade resultMessage;
    //*[@id="result-info"]/div[2]/div/h2
    //*[@id="result-info"]/div[2]/h2
    private String getResultMessage(){
       return resultMessage.getText();
    }

    public void confirmResultMessage(String expectedMessage){
        Assert.assertTrue(getResultMessage().equalsIgnoreCase(expectedMessage));
    }
}
