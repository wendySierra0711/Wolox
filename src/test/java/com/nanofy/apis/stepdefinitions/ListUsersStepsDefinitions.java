package com.nanofy.apis.stepdefinitions;


import com.nanofy.apis.questions.VerifyResponseCode;
import com.nanofy.apis.questions.VerifyRole;
import com.nanofy.apis.tasks.Consult;
import com.nanofy.apis.tasks.ConsultApiWithout;
import com.nanofy.apis.tasks.LoginTo;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import static com.nanofy.apis.model.enums.ApiNames.get;
import static com.nanofy.apis.model.enums.ConstantsEnv.AUTHORIZATION;
import static com.nanofy.apis.model.enums.ConstantsEnv.URL_QA;
import static com.nanofy.apis.util.Credentials.credentidals;
import static com.nanofy.apis.util.Credentials.environment;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ListUsersStepsDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());

    }

    @Given("^the (.*) in the application with (.*) role$")
    public void theLoginInTheApplicationWithAdministratorRole(String apiName, String rolName) {
        theActorCalled(rolName).whoCan(CallAnApi.at(environment(URL_QA)));
        theActorInTheSpotlight().attemptsTo(LoginTo.theApp(get(apiName).getPath(), credentidals(rolName)));
        theActorInTheSpotlight().remember(AUTHORIZATION, lastResponse().headers().get(AUTHORIZATION).getValue());

    }

    @When("consult the (.*)$")
    public void consultTheList(String apiName) {
        theActorInTheSpotlight().attemptsTo(Consult.list(get(apiName).getPath()));
    }

    @Then("^the user validates that the information is displayed correctly$")
    public void theUserValidatesThatTheInformationIsDisplayedCorrectly() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(200)));
    }

    @Then("^validate the role of returned users$")
    public void validateTheRoleOfReturnedUsers() {
        theActorInTheSpotlight().should(seeThat(VerifyRole.names(), not(containsString("admin"))));
    }

    @Then("^validate the returned roles$")
    public void validateTheReturnedRoles() {

    }

    @Given("(.*) validate the authorization (.*)$")
    public void  youValidateAuthorizationToken(String rolName ,String token ) {
        theActorCalled(rolName).whoCan(CallAnApi.at(environment(URL_QA)));
        theActorInTheSpotlight().remember(AUTHORIZATION, token);

    }

    @Then("^the user validate that the information is not displayed correctly$")
    public void theUserValidateThatTheInformationIsNotDisplayed() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(401)));
    }


    @Then("^the user validates that he does not have permissions for the information$")
    public void theUserValidatesThaTheDoesNotHavePermissions() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(403)));
    }
    @When("to consult (.*) without token$")
    public void withoutTokenTheConsultIsMade(String apiName) {
        theActorInTheSpotlight().attemptsTo(ConsultApiWithout.token(get(apiName).getPath()));
    }

}
