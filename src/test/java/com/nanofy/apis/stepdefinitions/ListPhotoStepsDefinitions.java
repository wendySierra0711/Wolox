package com.nanofy.apis.stepdefinitions;


import com.nanofy.apis.tasks.ConsultPhotos;
import cucumber.api.java.en.When;

import static com.nanofy.apis.model.enums.ApiNames.get;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ListPhotoStepsDefinitions {


    @When("^consult (.*) of the album with id (\\d+)$")
    public void consultListPhotosOfTheAlbumWithId(String apiName,Integer idAlbum) {
        theActorInTheSpotlight().attemptsTo(ConsultPhotos.fromAlbum(get(apiName).getPath(),idAlbum));
    }

}
