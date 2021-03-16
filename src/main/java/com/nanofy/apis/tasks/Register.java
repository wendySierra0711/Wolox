package com.nanofy.apis.tasks;


import com.google.gson.Gson;
import com.nanofy.apis.model.Client;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Register implements Task {
    private String path;
    private List<Client> data;

    public Register(String path, List<Client> data) {
        this.path = path;
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .body(new Gson().toJson(data).replace("[", "").replace("]", ""))
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }

    public static Register client(String path, List<Client> data)
    {
       return Tasks.instrumented(Register.class,path,data);
    }
}
