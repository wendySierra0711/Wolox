package com.nanofy.apis.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ConsultWithout implements Task {
    private String path;
    private String paramName;
    private Integer id;

    public ConsultWithout(String path, String paramName, Integer id) {
        this.path = path;
        this.paramName = paramName;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .pathParam(paramName, id)
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }
    public static ConsultWithout token(String path, String paramName,Integer id)
    {
       return Tasks.instrumented(ConsultWithout.class,path,paramName,id);
    }
}
