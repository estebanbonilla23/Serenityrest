package stepdefinitions;

import Questions.ResponseCodeQuestion;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GeneralStepDefinitions {

    /**
     * generic assert for get methods
     * @param response of elements
     * @param expectedResponseCode of the response
     */
    public static void validateGetResponse(Object response, int expectedResponseCode){

        theActorInTheSpotlight().should(
                seeThat("content-type", act -> SerenityRest.lastResponse().header("Content-Type"), equalTo("application/json; charset=utf-8")),
                seeThat("code response", ResponseCodeQuestion.was(), equalTo(expectedResponseCode)),
                seeThat("list is not null", act -> response, notNullValue())
        );
    }
}
