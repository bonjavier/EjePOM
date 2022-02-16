package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feactures/agregarpcs.feacture",
        glue = "definitions",
        tags = {"@casofallido"},
        snippets = CAMELCASE

)

public class agregarRunner {
}
