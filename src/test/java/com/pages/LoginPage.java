package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author ajina 23-03-2023
 * @see Used to maintain the locators for LoginPage
 */
public class LoginPage extends BaseClass {
	/**
	 * @see Used to access the class properties to another class
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtUsername;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[contains(text(),'Invalid Login')]")
	private WebElement txtErrorMessageLogin;

	public WebElement getTxtErrorMessageLogin() {
		return txtErrorMessageLogin;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @see Used for login common steps
	 */
	public void loginCommonSteps(String username, String password) {
		elementSendkeys(getTxtUsername(), username);
		elementSendkeys(getTxtPassword(), password);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @see Used for login and perform click
	 */

	public void login(String username, String password) {
		loginCommonSteps(username, password);
		elementClick(getBtnLogin());
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @see Used to login with Enter key
	 */

	public void loginWithEnterKey(String username, String password) {
		elementSendkeys(getTxtUsername(), username);
		elementWithEnterKey(getTxtPassword(), password);
	}

	/**
	 * 
	 * @return String
	 * @see Used to login error message
	 */
	public String getLoginErrorMsg() {
		String actLoginErrorMsg = elementGetText(getTxtErrorMessageLogin());

		return actLoginErrorMsg;
	}

}
