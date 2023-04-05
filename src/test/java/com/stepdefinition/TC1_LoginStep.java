package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author ajina 28-03-2023
 * @see Used to Omr Branch hotel login Automation
 *
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see Used to launch the browser
	 */
	@Given("User is on the Omr Branch hotel page")
	public void user_is_on_the_omr_branch_hotel_page() throws FileNotFoundException, IOException {
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @ Used to login with valid data
	 */
	@When("User login the {string},{string}")
	public void user_login_the(String username, String password) {
		pom.getLoginPage().login(username, password);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @see Used to login with Enter Key
	 */
	@When("User login the {string},{string} with ENTER key")
	public void user_login_the_with_enter_key(String username, String password) {
		pom.getLoginPage().loginWithEnterKey(username, password);
	}

	/**
	 * 
	 * @param expLoginErrorMsg
	 * @see Used to verify the error message after login with invalid credential
	 */
	@Then("User should verify error message after login {string}")
	public void user_should_verify_error_message_after_login(String expLoginErrorMsg) {
		Assert.assertTrue("Verify after login with invalid credentials error  message conntians",
				pom.getLoginPage().getLoginErrorMsg().contains(expLoginErrorMsg));

	}

}
