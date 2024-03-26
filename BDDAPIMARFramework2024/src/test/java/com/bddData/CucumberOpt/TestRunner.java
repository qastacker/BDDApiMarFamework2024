package com.bddData.CucumberOpt;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/bddData/features",
glue={"com.bddData.CucumberOpt"}
)
public class TestRunner {

}
