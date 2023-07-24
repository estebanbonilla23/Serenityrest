package stepdefinitions.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {
    EnvironmentVariables environmentalVariables;

    @Before
    public void set_the_stage(){
        String baseUrl = String.valueOf(environmentalVariables.getProperty("environments.qa.base.url"));
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(baseUrl)));
    }

    @After
    public void after() {
        System.out.println("after Hook");
    }
}
