package com.nanofy.apis.tasks;


import com.google.gson.Gson;
import com.nanofy.apis.model.Client;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Buy implements Task {
    private String path;
    private Integer id;

    public Buy(String path, Integer id) {
        this.path = path;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .header("Authorization", actor.recall("Authorization"))
                        .pathParam("idAlbum",id)
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }

    public static Buy theAlbum(String path,Integer id)
    {
       return Tasks.instrumented(Buy.class,path,id);
    }
}
