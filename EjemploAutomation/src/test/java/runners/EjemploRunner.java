package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/agregarCarrito.feature",
        glue = "stepdefinitions",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class EjemploRunner {
}
