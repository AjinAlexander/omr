package com.stepdefinition;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author ajina 28-03-2023
 * @see Used to OMR Branch Select hotel page Automation
 */
public class TC3_SelectHotelStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Used to select the hotel
	 */
	@When("User select the hotel")
	public void user_select_the_hotel() {
		pom.getSelectHotelPage().clickContinue();
	}

	/**
	 * @see Used to accept the alert
	 */
	@When("User accept the alert message")
	public void user_accept_the_alert_message() {
		pom.getSelectHotelPage().selectHotelWithAccept();
	}

	/**
	 * @see Used to dismiss the alert
	 */
	@When("User dismiss the alert message")
	public void user_dismiss_the_alert_message() {
		pom.getSelectHotelPage().selectHotelWithDismiss();
	}

	/**
	 * @see Used to click the radio button high to low
	 */
	@When("User click the radio button High to low")
	public void user_click_the_radio_button_high_to_low() {
		pom.getSelectHotelPage().clickRadioButton();
	}

	/**
	 * @see Used to verify the decending order
	 */
	@Then("User should verify decending order")
	public void user_should_verify_decending_order() {
		pom.getSelectHotelPage().sortHotelPriceHighToLow();
	}

	/**
	 * 
	 * @param roomType
	 * @see Used to verify the hotel name ends with roomtype
	 */
	@Then("User should verify hotel name ends with {string}")
	public void user_should_verify_hotel_name_ends_with(String roomType) {
		pom.getSelectHotelPage().hotelNameEndsWithRoomType();
	}

}
