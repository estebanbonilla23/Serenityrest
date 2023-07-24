package Tasks;

import Interactions.Patch;
import Models.Queries.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PatchPost implements Task {

    private final Post info;
    private final int id;

    public PatchPost(Post info, int id){
        this.info = info;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to(String.format("posts/%s", id))
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(info)));
    }

    public static Performable with(Post post, int id){

        return instrumented(PatchPost.class, post, id);
    }

}
