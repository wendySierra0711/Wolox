package com.nanofy.apis.stepdefinitions;


import com.nanofy.apis.questions.VerifyResponseCode;
import com.nanofy.apis.tasks.Buy;
import com.nanofy.apis.tasks.BuyAlbumWithout;
import com.nanofy.apis.tasks.ConsultApiWithout;
import com.nanofy.apis.tasks.LoginTo;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.nanofy.apis.model.enums.ApiNames.get;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class BuyAlbumStepsDefinitions {

    @When("^the user (.*) with (\\d+)$")
    public void theUserBuyAlbumWith(String apiName,Integer id) {
        theActorInTheSpotlight().attemptsTo(Buy.theAlbum(get(apiName).getPath(),id));
    }
    @Then("^the user validate the buy is successfully$")
    public void theUserValidateTheBuyIsSuccessfully() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(201)));
    }
    @Then("^the user validates that he does not allow to buy the album$")
    public void theUserValidatesDoesNotAllowTheBuyAlbum() {
        theActorInTheSpotlight().should(seeThat(VerifyResponseCode.isSuccessfully(), equalTo(422)));
    }
    @When("^(.*) without token with idAlbum (\\d+)$")
    public void withoutTokenBuyAlbumWithIdAlbum(String apiName,Integer id) {
        theActorInTheSpotlight().attemptsTo(BuyAlbumWithout.token(get(apiName).getPath(),id));
    }
}
