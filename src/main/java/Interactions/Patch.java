package Interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Patch extends RestInteraction {
    private final String resource;

    public Patch(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a PATCH on the resource #resource")
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().patch(as(actor).resolve(this.resource))
                .then().log().all();
    }

    public static Patch to(String resource) {
        return instrumented(Patch.class, resource);
    }
}