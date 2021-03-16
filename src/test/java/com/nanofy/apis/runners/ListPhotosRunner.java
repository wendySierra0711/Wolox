package com.nanofy.apis.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions
        (
                features = "src/test/resources/features/list_photos.feature",
                glue = "com.nanofy.apis.stepdefinitions",
                snippets = SnippetType.CAMELCASE
        )
public class ListPhotosRunner {
}
