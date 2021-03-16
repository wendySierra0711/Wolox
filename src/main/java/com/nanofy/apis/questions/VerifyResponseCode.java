package com.nanofy.apis.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyResponseCode implements Question<Integer>
{

    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().statusCode();
    }
    public static VerifyResponseCode isSuccessfully(){
        return new VerifyResponseCode();
    }


}
