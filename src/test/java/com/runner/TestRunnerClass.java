package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags=(""),dryRun=false,monochrome=true,stepNotifications=false,plugin = { "pretty", "json:target/OMRBranch.json"},glue = "com.stepdefinition",publish=false, features = "src\\test\\resources\\Features")

/**
 * 
 * @author ajina 22-02-2023
 * @see Used to provide the link between the feature file and step definition
 *      file and executing the tests.
 *
 */
public class TestRunnerClass extends BaseClass {
	
	
	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(getProjectPath() + "\\target\\OMRBranch.json");

	}

}
