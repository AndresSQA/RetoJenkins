package in.reqres.stepDefinitions;

import in.reqres.tasks.GetUsers;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.assertj.core.api.Assertions.assertThat;

public class ObtenerUsuarios {
    private Actor Usuario = Actor.named("User");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("El usuario consume el endpoint y la pagina {int}")
    public void el_usuario_consume_el_endpoint_y_la_pagina(Integer pagina) {


        Usuario = Actor.named("Andres").whoCan(
                CallAnApi.at("https://reqres.in/api/")
        );
        Usuario.attemptsTo(
                GetUsers.enLaPagina(pagina)
        );

    }

    @When("se obtenga el codigo y cuerpo de la respuesta")
    public void se_obtenga_el_codigo_y_cuerpo_de_la_respuesta() {

    }

    @Then("podra ver los datos de usuarios en la pagina enviada y el {int} con el status")
    public void podra_ver_los_datos_de_usuarios_en_la_pagina_enviada_y_el_con_el_status(Integer status) {
        assertThat(SerenityRest.lastResponse().getStatusCode()).isEqualTo(status);
    }

}
