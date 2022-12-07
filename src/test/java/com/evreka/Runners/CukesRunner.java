package com.evreka.Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"json:target/cucumber.json",
                "pretty","summary","html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/Features",
        monochrome = false,
        glue = "com/evreka/Step_Def",
        dryRun = false,
        tags ="@parcel"

        //mvn clean verify -Dcucumber.filter.tags="@asset"
)

public class CukesRunner {
}
