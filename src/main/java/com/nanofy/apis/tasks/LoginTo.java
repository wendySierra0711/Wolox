package com.nanofy.apis.tasks;


import com.google.gson.Gson;
import com.nanofy.apis.model.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class LoginTo implements Task {
    private String path;
    private List<Login> data;

    public LoginTo(String path, List<Login> data) {
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

    public static LoginTo theApp(String path, List<Login> data) {
        return Tasks.instrumented(LoginTo.class, path, data);
    }
}
