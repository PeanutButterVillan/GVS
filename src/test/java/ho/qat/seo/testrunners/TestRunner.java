package ho.qat.seo.testrunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "ho.qat.stepDefinitions",
        plugin = "pretty",
        tags = ""
)
public class TestRunner {
}

