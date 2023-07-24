package stepdefinitions;

import Models.Queries.Post;
import Questions.GetUpdatedQuestion;
import Tasks.DeletePost;
import Tasks.PutPost;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_OK;
import static stepdefinitions.GeneralStepDefinitions.validateGetResponse;

public class DeleteStepDefinitions {

    @When("He deletes a post")
    public void heDeletesAPost() {

        Faker faker = new Faker();
        int id = faker.number().numberBetween(1, 100);
        theActorInTheSpotlight().attemptsTo(DeletePost.with(id));
    }

    @Then("He can validate the put response")
    @Then("He can validate the patch response")
    @Then("He can validate the delete response")
    public void heCanValidateTheResponse() {

        Models.Response.Post post = new GetUpdatedQuestion().answeredBy(theActorInTheSpotlight());
        validateGetResponse(post, SC_OK);
    }
}
