package com.nanofy.apis.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Invalidate implements Task {
    private String path;

    public Invalidate(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .header("Authorization", actor.recall("Authorization"))
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }

    public static Invalidate session(String path)
    {
       return Tasks.instrumented(Invalidate.class,path);
    }
}
