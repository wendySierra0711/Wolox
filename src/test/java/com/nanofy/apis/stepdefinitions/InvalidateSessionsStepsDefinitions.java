package com.nanofy.apis.stepdefinitions;


import com.nanofy.apis.questions.VerifyResponseCode;
import com.nanofy.apis.tasks.Buy;
import com.nanofy.apis.tasks.Invalidate;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.nanofy.apis.model.enums.ApiNames.get;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class InvalidateSessionsStepsDefinitions {
    @When("^the (.*) process runs$")
    public void theInvalidateSession(String apiName) {
        theActorInTheSpotlight().attemptsTo(Invalidate.session(get(apiName).getPath()));
    }

    @Then("^validates that the session was invalidated$")
    public void validatesThatTheSessionWasInvalidated() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(200)));
    }

}
