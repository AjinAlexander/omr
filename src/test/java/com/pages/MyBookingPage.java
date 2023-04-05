package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author ajina
 * 22-03-2023
 * @see Used to maintain the locators for MyBookingPage
 *
 */
public class MyBookingPage extends BaseClass {
	/**
	 * @see Used to access the class properties to another class
	 */

	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement btnWelcome;

	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement btnMyAccount;
	
	@FindBy(id = "step2")
	private WebElement btnMyBooking;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement txtSearchBox;

	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//li[text()='Your booking cancelled successfully']")
	private WebElement txtCancelSuccessMsg;
	
	
	@FindBy(xpath = "//a//h5")
	private WebElement txtHotelName;
	

	
	public WebElement getBtnMyBooking() {
		return btnMyBooking;
	}

	public WebElement getTxtHotelName() {
		return txtHotelName;
	}

	public WebElement getTxtCancelSuccessMsg() {
		return txtCancelSuccessMsg;
	}

	public WebElement getBtnWelcome() {
		return btnWelcome;
	}

	public WebElement getBtnMyAccount() {
		return btnMyAccount;
	}

	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
		
		
	}
//	public void bookingPageAccept() {
//		alertOk();
//	}


	/**
	 * 
	 * @param orderId
	 * @throws InterruptedException 
	 * @see Used to cancel the hotel
	 */
	public void cancelOrderId() throws InterruptedException {
//		navigateMyBookingTab();
		Thread.sleep(5000);
		elementClick(getBtnCancel());
		alertOk();

	}
/**
 * @see Used to navigate my booking tab
 */
	public void navigateMyBookingTab() {
		elementClick(getBtnWelcome());
		elementClick(getBtnMyAccount());
		elementClick(getBtnMyBooking());
		elementSendkeys(getTxtSearchBox(), BookingConfirmationPage.bookingId);
		

	}
	/**
	 * 
	 * @return String
	 * @see Used to get cancel success message
	 */
	public String getTxtCancelSuccessMessage() {
		String actCancelSuccessMsg = elementGetText(getTxtCancelSuccessMsg());
		return actCancelSuccessMsg;
	}
	/**
	 * 
	 * @return String
	 * @see Used to get hotel name
	 */
	
	public String getTextHotelName() {
		implicityWait();
		String actTextHotelName = elementGetText(getTxtHotelName());
		return actTextHotelName;
	}
}
