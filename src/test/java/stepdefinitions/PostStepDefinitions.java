package stepdefinitions;

import Models.Queries.Post;
import Questions.CreatePostsQuestion;
import Tasks.CreateAPost;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_CREATED;
import static stepdefinitions.GeneralStepDefinitions.validateGetResponse;

public class PostStepDefinitions {

    @When("He sent the post method")
    public void heSentThePostMethod() {

        Faker faker = new Faker();
        int id = faker.number().numberBetween(1, 10);
        String title = faker.name().title();
        String number = faker.business().creditCardNumber();

        Post post = Post.builder()
                .userId(id).title(title).body(number).build();
        theActorInTheSpotlight().attemptsTo(CreateAPost.with(post));
    }

    @Then("He can validate the post response")
    public void heCanValidateThePostsResponse() {

        Models.Response.Post post = new CreatePostsQuestion().answeredBy(theActorInTheSpotlight());
        validateGetResponse(post, SC_CREATED);
    }
}
