package Facts;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

import java.util.HashMap;
import java.util.List;

public class GetPosts implements Fact {

    private List<HashMap<String, String>> data;

    public static GetPosts all(){
        return  new GetPosts();
    }

    @Override
    public void setup(Actor actor) {
        actor.attemptsTo(Tasks.GetPosts.with(1));
        data = SerenityRest.lastResponse().path("data");
        actor.remember("data", data);

    }

    public String toString(){
        return String.format("The posts are: %s", data.toString());
    }
}
