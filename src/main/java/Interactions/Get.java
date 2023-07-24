package Interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Get extends RestInteraction {
    private final String resource;

    public Get(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a GET on the resource #resource")
    public <T extends Actor> void performAs(T actor) {
        System.out.println("resource: "+resource);
        rest().log().all().get(as(actor).resolve(this.resource))
                .then().log().all();
    }

    public static Get resource(String resource) {
        return instrumented(Get.class, resource);
    }
}

