package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;
import com.pages.BookHotelPage;

import io.cucumber.java.en.Then;

/**
 * 
 * @author ajina 28-03-2023
 * @see Used to get commmon steps
 */
public class Commonstep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @param expLoginSuccessMsg
	 * @see Used to verify success message after login
	 */
	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String expLoginSuccessMsg) {

		Assert.assertEquals("Verify after login success message after login", expLoginSuccessMsg,
				pom.getExploreHotelPage().getLoginSuccessMsg());

	}

	/**
	 * 
	 * @param expAfterSelectHotel
	 * @see Used to verify success message after select hotel
	 */
	@Then("User should verify success message after select hotel {string}")
	public void user_should_verify_success_message_after_select_hotel(String expAfterSelectHotel) {
		Assert.assertEquals("Verify after login success message", expAfterSelectHotel,
				pom.getSelectHotelPage().successMsgAfterSelectHotel());
	}

	/**
	 * 
	 * @param roomType
	 * @see Used to verify selected filter room type is displayed
	 */
	@Then("User should verify selected filter room type is displayed {string}")
	public void user_should_verify_selected_filter_room_type_is_displayed(String roomType) {
		Assert.assertEquals("verify selected filter room type is displayed", roomType,
				pom.getSelectHotelPage().filterSuccessMsg());

	}

	/**
	 * 
	 * @param exptSuccessMsgAftertBookHotel
	 * @see Used verify success message after book hote and save the hotel name
	 */
	@Then("User should verify success message after book hotel {string} and save the hotel name")
	public void user_should_verify_success_message_after_book_hotel_and_save_the_hotel_name(
			String exptSuccessMsgAftertBookHotel) {
		Assert.assertTrue("Verify after success message after select hotel ",
				pom.getBookHotelPage().successAfterBookHotel().contains(exptSuccessMsgAftertBookHotel));
	}

	/**
	 * 
	 * @param string
	 * @see Used to verify success message after book hotel and save the order id
	 */
	@Then("User should verify success message after book hotel {string} and save the order id")
	public void user_should_verify_success_message_after_book_hotel_and_save_the_order_id(String expOrderId) {
		Assert.assertTrue("Verify Booking Confirmation after booking hotel",
				pom.getBookingConfirmationPage().getBookingConfirmText().contains(expOrderId));
		pom.getBookingConfirmationPage().getOrderId();
	}

	/**
	 * 
	 * @see Used to verify the booked hotel is present
	 */
	@Then("User should verify the booked hotel is present")
	public void user_should_verify_the_booked_hotel_is_present() {
		// Assert.assertTrue("Verify hotel name is present after order Id search",
		// pom.getMyBookingPage().getTextHotelName().contains(pom.getBookHotelPage().successAfterBookHotel()));
//		Assert.assertTrue("Verify hotel name is present after order Id search",
//				BookHotelPage.bookHotelMsg.contains(pom.getMyBookingPage().getTextHotelName()));
		Assert.assertTrue("Verify hotel name is present after order Id search", BookHotelPage.hotelName.contains(pom.getMyBookingPage()
				.getTextHotelName()));
	}

}
