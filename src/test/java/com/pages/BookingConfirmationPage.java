package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author ajina 22-03-2023
 * @see Used to maintain locator for BookingConfirmationPage
 *
 */
public class BookingConfirmationPage extends BaseClass {
	/**
	 * @see Used to access the class properties to another class
	 */

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2//strong")
	private WebElement getOrderId;

	@FindBy(xpath = "//h2[text()=' Booking is Confirmed ']")
	private WebElement BookingConfirmMsg;

	public WebElement getGetOrderId() {
		return getOrderId;
	}

	public WebElement getBookingConfirmMsg() {
		return BookingConfirmMsg;
	}

	/**
	 * @see Used to get the order id
	 */
	public static String bookingId;

	public void getOrderId() {
		String orderId = elementGetText(getGetOrderId()).replace("#", "");
		bookingId = orderId;
		System.out.println(orderId);
	}

	public String getBookingConfirmText() {
		String actBookingConfirmText = elementGetText(getBookingConfirmMsg()).trim();
		return actBookingConfirmText;
	}

}
