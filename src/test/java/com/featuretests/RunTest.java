package com.featuretests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber-htmlreport", "json:target/cucumber-report.json" },
		features = "src/test/resources/featurefiles/", 
		tags = "@test"
//		tags = "@PackageListing-DataDriven, @PackageListing-Simple"
		)
public class RunTest{
	
}