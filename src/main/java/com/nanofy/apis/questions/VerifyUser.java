package com.nanofy.apis.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyUser implements Question<String>
{

    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().jsonPath().getString("user_id");
    }
    public static VerifyUser idNotnull(){
        return new VerifyUser();
    }


}
