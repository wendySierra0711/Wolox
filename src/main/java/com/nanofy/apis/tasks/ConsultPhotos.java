package com.nanofy.apis.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ConsultPhotos implements Task {
    private String path;
    private Integer id;

    public ConsultPhotos(String path, Integer id) {
        this.path = path;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .header("Authorization", actor.recall("Authorization"))
                        .pathParam("idAlbum", id)
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }

    public static ConsultPhotos fromAlbum(String path, Integer id) {
        return Tasks.instrumented(ConsultPhotos.class, path, id);
    }
}
