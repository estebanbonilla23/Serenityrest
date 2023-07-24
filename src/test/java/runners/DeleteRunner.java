package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@delete_api",
        snippets = CAMELCASE,
        features = "src/test/resources/features/",
        glue = {"stepdefinitions"}
)
public class DeleteRunner {
}
