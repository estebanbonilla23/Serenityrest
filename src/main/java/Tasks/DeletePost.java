package Tasks;

import Interactions.Delete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePost implements Task {
    private final int id;

    public DeletePost(int id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.to(String.format("posts/%s", id))
                .with(requestSpecification -> requestSpecification));
    }

    public static Performable with(int id){

        return instrumented(DeletePost.class, id);
    }

}
