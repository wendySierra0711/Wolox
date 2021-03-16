package com.nanofy.apis.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ConsultApiWithout implements Task {
    private String path;

    public ConsultApiWithout(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }
    public static ConsultApiWithout token(String path)
    {
       return Tasks.instrumented(ConsultApiWithout.class,path);
    }
}
