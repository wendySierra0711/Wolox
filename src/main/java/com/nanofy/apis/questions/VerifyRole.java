package com.nanofy.apis.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyRole implements Question<String>
{

    @Override
    public String answeredBy(Actor actor) {
        return  lastResponse().jsonPath().getString("page.role");
    }
    public static VerifyRole names(){
        return new VerifyRole();
    }


}
