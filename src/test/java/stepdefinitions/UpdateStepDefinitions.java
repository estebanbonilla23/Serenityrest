package stepdefinitions;

import Models.Queries.Post;
import Tasks.PutPost;
import com.github.javafaker.Faker;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateStepDefinitions {

    @When("He updates a post")
    public void heUpdatesAPost() {

        Faker faker = new Faker();
        int id = faker.number().numberBetween(1, 10);
        String title = faker.name().title();
        String number = faker.business().creditCardNumber();

        Post update = Post.builder()
                .userId(id).title(title).body(number).build();
        theActorInTheSpotlight().attemptsTo(PutPost.with(update, id));
    }
}
