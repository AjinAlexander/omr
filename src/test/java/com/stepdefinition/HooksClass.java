package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		enterApplnUrl(getPropertyFileValue("url"));
		maximizeWindow();
		implicityWait();
	}

	
	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {
		boolean failed = scenario.isFailed();
		if (failed) {
			scenario.attach(sreenShot(), "images/png", "Every Scenario");

		}
		quitWindow();
	}
}
