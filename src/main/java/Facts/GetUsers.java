package Facts;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

import java.util.HashMap;
import java.util.List;

public class GetUsers implements Fact {

    private List<HashMap<String, String>> data;

    public static GetUsers all(){
        return  new GetUsers();
    }

    @Override
    public void setup(Actor actor) {
        actor.attemptsTo(Tasks.GetUsers.with(1));
        data = SerenityRest.lastResponse().path("data");
        actor.remember("data", data);

    }

    public String toString(){
        return String.format("The users are: %s", data.toString());
    }
}
