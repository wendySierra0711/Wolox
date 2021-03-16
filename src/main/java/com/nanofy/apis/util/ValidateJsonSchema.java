package com.nanofy.apis.util;


import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.FileInputStream;


public class ValidateJsonSchema {


    public static void validate(String response, FileInputStream name)  throws ValidationException{
        JSONObject jsonSchema =  new JSONObject(
                new JSONTokener(name));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(response));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
    }
}
