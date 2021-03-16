package com.nanofy.apis.stepdefinitions;


import com.nanofy.apis.exceptions.CreateUserException;
import com.nanofy.apis.model.Client;
import com.nanofy.apis.questions.VerifyResponse;
import com.nanofy.apis.questions.VerifyResponseCode;
import com.nanofy.apis.questions.VerifyUser;
import com.nanofy.apis.tasks.Register;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import java.util.List;

import static com.nanofy.apis.model.enums.ApiNames.get;
import static com.nanofy.apis.model.enums.ConstantsEnv.URL_QA;
import static com.nanofy.apis.util.Credentials.environment;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class RegisterClientStepsDefinitions {


    @Given("^the (.*) wants to create a new customer$")
    public void theUserWantsToCreateANewCustomer(String actorName) {
        theActorCalled(actorName).whoCan(CallAnApi.at(environment(URL_QA)));
    }


    @When("^the user (.*) with the following data$")
    public void theUserCreatesTheClientWithTheFollowingData(String apiName,List<Client> data) {
        theActorInTheSpotlight().attemptsTo(Register.client(get(apiName).getPath(),data));
    }

    @Then("^the user validates that the client was registered successfully$")
    public void theUserValidatesThatTheClientWasRegisteredSuccessfully() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(201)));
        theActorInTheSpotlight().should(seeThat(VerifyUser.idNotnull(), not(equalTo("[null]")))
                .orComplainWith(CreateUserException.class, "El cliente no pudo ser creado,por favor verifique"));

    }
    @Then("^the user validates that the (.*) and (.*) is displayed correctly$")
    public void theUserValidatesThatAndIsDisplayed(String codeMessage,String message) {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(422)));
        theActorInTheSpotlight().should(seeThat(VerifyResponse.messages("errors.code"), equalTo(codeMessage)));
        theActorInTheSpotlight().should(seeThat(VerifyResponse.messages("errors.message"), equalTo(message)));
    }

    @Then("^the user validates the mandatory fields with (.*) and (.*)$")
    public void ThenTheUserValidatesTheMandatoryFields(String codeMessage,String message) {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(400)));
        theActorInTheSpotlight().should(seeThat(VerifyResponse.messages("errors.code"), equalTo(codeMessage)));
        theActorInTheSpotlight().should(seeThat(VerifyResponse.messages("errors.message"), equalTo(message)));
    }





}
