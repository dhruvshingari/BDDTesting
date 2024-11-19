package com.nagarro.BDDTesting;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				 glue = {"com.nagarro.BDDTesting.StepDef","com.nagarro.BDDTesting.Hooks"},
				 plugin = {"pretty",
						 "html:target/cucumber-reports.html",
						 "json:target/cucumber-reports/cucumber.json"
				 },
				 tags = "@Product or @Login or @Home"
				 )

public class TestRunner extends AbstractTestNGCucumberTests{

	
}
