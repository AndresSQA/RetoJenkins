package in.reqres.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Task {

    private int pagina;

    public GetUsers(int pagina){
        this.pagina=pagina;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String respuestaservicio;
        actor.attemptsTo(Get.resource("users?page="+pagina));
        respuestaservicio= lastResponse().getBody().asString();
        System.out.println("Body - Respuesta del servicio: "+respuestaservicio);
        System.out.println("StatusCode= " + lastResponse().getStatusCode());
    }


    public static GetUsers enLaPagina(int pagina) {
        return instrumented(GetUsers.class,pagina);
    }
}
