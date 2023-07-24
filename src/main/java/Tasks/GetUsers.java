package Tasks;

import Interactions.Get;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Task {

    private final int page;

    public GetUsers(int page){
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(String.format("users?page=%s", page))
                .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)));
    }

    public static Performable with(int page){

        return instrumented(GetUsers.class, page);
    }

}
