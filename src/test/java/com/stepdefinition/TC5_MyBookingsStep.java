package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author ajina 28-03-2023
 * @see Used to OMR Branch My Bookings Page hotel page Automation
 *
 */
public class TC5_MyBookingsStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Used to navigate into my booking tabs
	 */
	@When("User navigate into my booking tabs")
	public void user_navigate_into_my_booking_tabs() {
		pom.getMyBookingPage().navigateMyBookingTab();
	}

	

	/**
	 * 
	 * @throws InterruptedException
	 * @see Used to cancel the order id
	 */
	@When("User cancel the order id")
	public void user_cancel_the_order_id() throws InterruptedException {
		pom.getMyBookingPage().cancelOrderId();

	}

	/**
	 * 
	 * 
	 * @param expSuccessMsgAfterMyBookingPage
	 * @see Used to verify success message after my bookings page
	 */
	@Then("User should verify success message after my bookings page {string}")
	public void user_should_verify_success_message_after_my_bookings_page(String expSuccessMsgAfterMyBookingPage) {
		Assert.assertEquals("Verify success message after cancel booking", expSuccessMsgAfterMyBookingPage,
				pom.getMyBookingPage().getTxtCancelSuccessMessage());

	}

}
