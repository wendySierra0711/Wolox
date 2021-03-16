package com.nanofy.apis.stepdefinitions;


import com.nanofy.apis.exceptions.UpdateUserException;
import com.nanofy.apis.model.Login;
import com.nanofy.apis.questions.VerifyAuthorization;
import com.nanofy.apis.questions.VerifyResponseCode;
import com.nanofy.apis.questions.VerifyUser;
import com.nanofy.apis.tasks.LoginTo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static com.nanofy.apis.model.enums.ApiNames.get;
import static com.nanofy.apis.model.enums.ConstantsEnv.AUTHORIZATION;
import static com.nanofy.apis.model.enums.ConstantsEnv.URL_QA;
import static com.nanofy.apis.util.Credentials.environment;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class LoginUserStepsDefinitions {

    @Given("^the (.*) wants to login to the application$")
    public void theUserWantsToLogIntoTheApplication(String actorName) {
        theActorCalled(actorName).whoCan(CallAnApi.at(environment(URL_QA)));
    }

    @When("^The user (.*) with the data$")
    public void theUserEntersWithTheData(String apiName, List<Login> data) {
        theActorInTheSpotlight().attemptsTo(LoginTo.theApp(get(apiName).getPath(), data));
        theActorInTheSpotlight().remember(AUTHORIZATION, lastResponse().headers().get(AUTHORIZATION).getValue());
    }
    @When("^The user (.*) with the wrong data$")
    public void theUserEntersWithTheWrongData(String apiName, List<Login> data) {
        theActorInTheSpotlight().attemptsTo(LoginTo.theApp(get(apiName).getPath(), data));
    }



    @Then("^the user validates that he was logged in correctly$")
    public void theUserValidatesThatHeWasLoggedInCorrectly() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(200)));
        theActorInTheSpotlight().should(seeThat(VerifyUser.idNotnull(), not(equalTo("[null]"))));
        theActorInTheSpotlight().should(seeThat(VerifyAuthorization.notnull(), not(Matchers.isEmptyOrNullString()))
                .orComplainWith(UpdateUserException.class, "No se ingresó  correctamente a la aplicación"));

    }
    @And("^the user validates json schema for (.*)$")
    public void theUserValidatesJsonSchema(String name) throws ValidationException, FileNotFoundException {
        FileInputStream jsonfile= new FileInputStream(new File("src/test/resources/json/"+name+".json"));
        JSONObject jsonSchema =  new JSONObject(new JSONTokener(jsonfile));
        String response =lastResponse().getBody().asString();
        Schema schema = SchemaLoader.load(jsonSchema);
        if (response.charAt(0)== '[') schema.validate(new JSONArray(new JSONTokener(response)));
        else  schema.validate(new JSONObject(new JSONTokener(response)));
    }

}
