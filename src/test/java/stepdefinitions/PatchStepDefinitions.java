package stepdefinitions;

import Models.Queries.Post;
import Tasks.PatchPost;
import com.github.javafaker.Faker;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PatchStepDefinitions {

    @When("He updates partially a post")
    public void heUpdatesPartiallyAPost() {

        Faker faker = new Faker();
        int id = faker.number().numberBetween(1, 10);
        String title = faker.name().title();

        Post patch = Post.builder()
                .userId(2).title(title).build();
        theActorInTheSpotlight().attemptsTo(PatchPost.with(patch, id));
    }
}
