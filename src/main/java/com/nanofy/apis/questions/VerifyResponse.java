package com.nanofy.apis.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyResponse implements Question<String>
{
   private String path;

    public VerifyResponse(String path) {
        this.path = path;
    }

    @Override
    public String answeredBy(Actor actor) {
        return  lastResponse().jsonPath().getString(path).replace("[","").replace("]","");
    }
    public static VerifyResponse messages(String path){
        return new VerifyResponse(path);
    }


}
