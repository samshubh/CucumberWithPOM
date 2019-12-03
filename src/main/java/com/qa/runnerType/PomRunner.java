package com.qa.runnerType;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		   features ="C:\\Users\\vt1056.SRITADS\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\com\\qa\\feature\\pom.feature"
		   ,glue="com.qa.stepDefinition"
		   ,format= {"pretty","html:test-output","json:CRM_JSON/crm_json_output","junit:CRM_xml/crm_xml_output"}
		   ,monochrome= true
		   ,strict= false
		   ,dryRun= false

		   )
public class PomRunner {

}
