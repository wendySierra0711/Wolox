package com.nanofy.apis.stepdefinitions;


import com.nanofy.apis.tasks.ConsultPurchased;
import com.nanofy.apis.tasks.ConsultWithout;
import cucumber.api.java.en.When;

import static com.nanofy.apis.model.enums.ApiNames.get;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ListPurchasedAlbumsStepsDefinitions {

    @When("^consult (.*) of the customer with id (\\d+)$")
    public void consultListPurchasedAlbumsOfTheCustomerWithId(String apiName, Integer idUser) {
        theActorInTheSpotlight().attemptsTo(ConsultPurchased.albums(get(apiName).getPath(), idUser));
    }
    @When("^without token the consult (.*) with (.*) (\\d+)$")
    public void withoutTokenTheConsultListWithId(String apiName,String paramName, Integer idUser) {
        theActorInTheSpotlight().attemptsTo(ConsultWithout.token(get(apiName).getPath(),paramName,idUser));
    }
}
