package com.nanofy.apis.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
public class Consult implements Task {
    private String path;

    public Consult(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .header("Authorization", actor.recall("Authorization"))
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }
    public static Consult list(String path)
    {
       return Tasks.instrumented(Consult.class,path);
    }
}
