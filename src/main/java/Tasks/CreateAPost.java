package Tasks;

import Interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateAPost implements Task {

    private final Models.Queries.Post info;

    public CreateAPost(Models.Queries.Post info){
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("posts")
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(info)));
    }

    public static Performable with(Models.Queries.Post info){

        return instrumented(CreateAPost.class, info);
    }

}
