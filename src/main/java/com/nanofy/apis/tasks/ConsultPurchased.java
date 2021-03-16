package com.nanofy.apis.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ConsultPurchased implements Task {
    private String path;
    private Integer id;

    public ConsultPurchased(String path, Integer id) {
        this.path = path;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .header("Authorization", actor.recall("Authorization"))
                        .pathParam("idUser", id)
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }

    public static ConsultPurchased albums(String path, Integer id) {
        return Tasks.instrumented(ConsultPurchased.class, path, id);
    }
}
