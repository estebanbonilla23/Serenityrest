package Questions;

import Models.Response.Post;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetPostsQuestion implements Question {

    public static Question<Post[]> was(){
        return new GetPostsQuestion();
    }

    @Override
    public Post[] answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Post[].class);
    }

}
