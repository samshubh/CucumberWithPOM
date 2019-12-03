package com.qa.runnerType;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		   features ="C:\\Users\\vt1056.SRITADS\\eclipse-workspace\\CucumberPOM2\\src\\main\\java\\com\\qa\\feature\\pom.feature"
		   ,glue="com.qa.stepDefinition"
		   ,format= {"pretty","html:target/cucumber-reports/cucumber-pretty",
				   "json:target/cucumber-reports/CucumberTestReport.json",
				   "rerun:target/cucumber-reports/rerun.txt"}
		   , plugin ="json:target/cucumber-reports/CucumberTestReport.json"
		)





public class PomRunner {

	private TestNGCucumberRunner testNGCucumberrunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {

		testNGCucumberrunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberrunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {

		return testNGCucumberrunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)

	public void tearDownClass() throws Exception {
		testNGCucumberrunner.finish();
	}

}
