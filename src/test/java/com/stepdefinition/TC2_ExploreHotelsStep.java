package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author ajina 28-03-2023
 * @see Used to OMR Branch Explore hotel page Automation
 *
 */
public class TC2_ExploreHotelsStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @param state
	 * @param city
	 * @param roomType
	 * @param checkin
	 * @param checkout
	 * @param no_room
	 * @param no_adult
	 * @param no_child
	 * @see Used to enter all field and search
	 */
	@When("User enter all field {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_enter_all_field_and(String state, String city, String roomType, String checkin, String checkout,
			String no_room, String no_adult, String no_child) {
		pom.getExploreHotelPage().exploreHotels(state, city, roomType, checkin, checkout, no_room, no_adult, no_child);
	}

	/**
	 * 
	 * @param state
	 * @param city
	 * @param checkin
	 * @param checkout
	 * @param no_room
	 * @param no_adult
	 * @see Used to enter mandatory field and search
	 */
	@When("User enter mandatory field {string},{string},{string},{string},{string} and {string}")
	public void user_enter_mandatory_field_and(String state, String city, String checkin, String checkout,
			String no_room, String no_adult) {
		pom.getExploreHotelPage().explorehotels(state, city, checkin, checkout, no_room, no_adult);
	}

	/**
	 * @see Used to clicks the search button
	 */
	@When("User clicks search button")
	public void user_clicks_search_button() {
		pom.getExploreHotelPage().clickSearchHotel();

	}

	/**
	 * 
	 * @param error1
	 * @param error2
	 * @param error3
	 * @param error4
	 * @param error5
	 * @param error6
	 * @see Used to verify error message after no option select
	 */
	@Then("User should verify error message after no options select {string} , {string} , {string} , {string} ,{string} and {string}")
	public void user_should_verify_error_message_after_no_options_select_and(String error1, String error2,
			String error3, String error4, String error5, String error6) {
		Assert.assertEquals("verify error message after no options select for State", error1,
				pom.getExploreHotelPage().error1());
		Assert.assertEquals("verify error message after no options select for City", error2,
				pom.getExploreHotelPage().error2());
		Assert.assertEquals("verify error message after no options select for checkin", error3,
				pom.getExploreHotelPage().error3());
		Assert.assertEquals("verify error message after no options select for checkout", error4,
				pom.getExploreHotelPage().error4());
		Assert.assertEquals("verify error message after no options select for noRoom", error5,
				pom.getExploreHotelPage().error5());
		Assert.assertEquals("verify error message after no options select for noAdult", error6,
				pom.getExploreHotelPage().error6());

	}

}
