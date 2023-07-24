package stepdefinitions;

import Facts.GetPosts;
import Facts.GetUsers;
import Models.Response.Post;
import Models.Response.User;
import Questions.GetPostsQuestion;
import Questions.GetUsersQuestion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_OK;
import static stepdefinitions.GeneralStepDefinitions.validateGetResponse;

public class GetStepDefinitions {

    @Given("^(.*) is a user$")
    public void estebanIsANewUser(String actorName) {

        theActorCalled(actorName).entersTheScene();
    }

    @When("He consults all the users")
    public void heConsultsAllTheUsers() {

        theActorInTheSpotlight().has(GetUsers.all());
    }

    @When("He consults all the posts")
    public void heConsultsAllThePosts() {

        theActorInTheSpotlight().has(GetPosts.all());
    }

    @Then("He can validate the users response")
    public void heCanValidateTheUsersResponse() {

        User[] users = new GetUsersQuestion().answeredBy(theActorInTheSpotlight());
        validateGetResponse(users, SC_OK);
    }

    @Then("He can validate the posts response")
    public void heCanValidateThePostsResponse() {

        Post[] posts = new GetPostsQuestion().answeredBy(theActorInTheSpotlight());
        validateGetResponse(posts, SC_OK);
    }
}
