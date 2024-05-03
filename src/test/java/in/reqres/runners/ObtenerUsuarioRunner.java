package in.reqres.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/in/reqres/features/ObtenerUsuarios.feature",
        glue = "in/reqres/stepDefinitions",
        tags = "@get",
        publish = false
)


public class ObtenerUsuarioRunner {
}
