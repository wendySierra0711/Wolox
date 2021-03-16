package com.nanofy.apis.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class BuyAlbumWithout implements Task {
    private String path;
    private Integer id;

    public BuyAlbumWithout(String path,Integer id) {
        this.path = path;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(path)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .pathParam("idAlbum",id)
                        .log().all().relaxedHTTPSValidation()));
        lastResponse().prettyPeek();
    }
    public static BuyAlbumWithout token(String path,Integer id)
    {
       return Tasks.instrumented(BuyAlbumWithout.class,path,id);
    }
}
