package com.nanofy.apis.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyAuthorization implements Question<String>
{

    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().headers().get("Authorization").getValue();
    }
    public static VerifyAuthorization notnull(){
        return new VerifyAuthorization();
    }


}
