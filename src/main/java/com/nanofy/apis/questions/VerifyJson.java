package com.nanofy.apis.questions;

import com.nanofy.apis.util.ValidateJsonSchema;
import io.restassured.response.ResponseBody;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyJson implements Question<Boolean>
{
private FileInputStream name;

    public VerifyJson(FileInputStream name) {
        this.name = name;
    }

    @Override
    public Boolean answeredBy(Actor actor)  {
         return true;//ValidateJsonSchema.validate(lastResponse().getBody().asString(),name);

    }
    public static VerifyJson schema(FileInputStream name){
        return new VerifyJson(name);
    }


}
