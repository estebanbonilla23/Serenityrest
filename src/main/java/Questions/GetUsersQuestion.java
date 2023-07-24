package Questions;

import Models.Response.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUsersQuestion implements Question {

    public static Question<User[]> was(){
        return new GetUsersQuestion();
    }

    @Override
    public User[] answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(User[].class);
    }

}
