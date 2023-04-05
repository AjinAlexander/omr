package com.stepdefinition;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.When;

/**
 * 
 * @author ajina 28-03-2023
 * @see Used to OMR Branch Book hotel page Automation
 *
 */
public class TC4_BookHotelStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @param selectSaluation
	 * @param firstName
	 * @param lastName
	 * @param mobileNo
	 * @param email
	 * @throws InterruptedException
	 * @see Used to add guest details
	 */
	@When("user add guest details {string},{string},{string},{string} and {string}")
	public void user_add_guest_details_and(String selectSaluation, String firstName, String lastName, String mobileNo,
			String email) throws InterruptedException {
		pom.getBookHotelPage().addGuestDetails(selectSaluation, firstName, lastName, mobileNo, email);
	}

	/**
	 * 
	 * @param registrationNo
	 * @param companyName
	 * @param companyAddress
	 * @see Used to add the GST details
	 */
	@When("User add GST details {string},{string} and {string}")
	public void user_add_gst_details_and(String registrationNo, String companyName, String companyAddress) {
		pom.getBookHotelPage().addGstDetails(registrationNo, companyName, companyAddress);
	}

	/**
	 * @see Used to accept the alert
	 */
	@When("User accept the alert")
	public void user_accept_the_alert() {
		pom.getBookHotelPage().bookingPageAccept();

	}

	/**
	 * 
	 * @param specialRequest
	 * @see Used to add special request
	 */
	@When("User add special request {string}")
	public void user_add_special_request(String specialRequest) {
		pom.getBookHotelPage().addSpecialRequest(specialRequest);
	}

	/**
	 * 
	 * @param cardType
	 * @param dataTable
	 * @see Used to add payment details
	 */
	@When("User add payment details,proceed with card type {string}")
	public void user_add_payment_details_proceed_with_card_type(String cardType,
			io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().addCardPaymentDetails(cardType, dataTable);

	}

	/**
	 * 
	 * @param upiId
	 * @see Used to select upi option
	 */
	@When("User select UPI option add  UPI id {string}")
	public void user_select_upi_option_add_upi_id(String upiId) {
		pom.getBookHotelPage().addPaymentUpi(upiId);
	}

}
