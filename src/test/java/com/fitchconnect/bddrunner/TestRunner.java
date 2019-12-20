package com.fitchconnect.bddrunner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


/**
 * Created by Miah Ashrafuzzaman.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/FitchConnectValidLogin.feature",
		glue = { "com.fitchconnect.steps" },
//		dryRun=true,
		//strict = true,
		monochrome = true,
		// tags= {"@FunctionalTest", "not @SmokeTest", "not @SanityTest","not
		// @End2EndTests"},
		plugin = {
				    "pretty:target/cucumber-test-report/cucumber-pretty.txt",
					"html:target/cucumber-test-report",
					"json:target/cucumber-test-report/cucumber-report.json",
				//	"junit:target/cucumber-test-report/test-report.xml",
				   "json:target/cucumber-test-report/test-report.json"}
				)

public class TestRunner {

}
