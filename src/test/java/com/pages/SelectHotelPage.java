package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author ajina 23-03-2023
 * @see Used to maintain the locators for SelectHotelPage
 */
public class SelectHotelPage extends BaseClass {

	/**
	 * @see Used to access the class properties to another class
	 */
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Continue'])[1]")
	private WebElement btnContinue;

	@FindBy(xpath = "//label[text()='Price High to low']")
	private WebElement rdoHighToLow;

	@FindBy(xpath = "//div[@class='col-md-5 hotel-suites']")
	private List<WebElement> hotels;

	@FindBy(xpath = "//div[@id='hotellist']")
	private List<WebElement> prices;

	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement successMsgAfterSelectHotel;

	@FindBy(id = "room_type")
	private WebElement filterRoomType;

	public WebElement getSuccessMsgAfterSelectHotel() {
		return successMsgAfterSelectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getRdoHighToLow() {
		return rdoHighToLow;
	}

	public List<WebElement> getHotels() {
		return hotels;
	}

	public List<WebElement> getPrices() {
		return prices;
	}

	public WebElement getFilterRoomType() {
		return filterRoomType;
	}

	public void clickRadioButton() {
		elementClick(getRdoHighToLow());
	}

	public void clickContinue() {
		elementClick(getBtnContinue());
	}

	/**
	 * @ Used to accept the alert
	 */
	public void selectHotelWithAccept() {
		alertOk();
	}

	/**
	 * @ Used to cancel the alert
	 */
	public void selectHotelWithDismiss() {
		alertCancel();
	}

	/**
	 * 
	 * @return List<Boolean>
	 * @see Used to verify the all hotel contains
	 */
	public List<Boolean> hotelNameEndsWithRoomType() {
		List<Boolean> hotels = new ArrayList<Boolean>();
		for (WebElement eachHotelName : getHotels()) {
			String hotelName = elementGetText(eachHotelName);
			boolean res = hotelName.contains(hotelName);
			hotels.add(res);
		}
		return hotels;

	}

	/**
	 * 
	 * @return boolean
	 * @see Used to sort the hotel price low to high
	 */
	public boolean sortHotelPriceHighToLow() {
		clickRadioButton();
		List<String> prices = new ArrayList<String>();
		for (WebElement all : getPrices()) {
			String text = all.getText();
			String hotels = text.replace("$", "").replace(",", "").trim();
			prices.add(hotels);
		}
		List<String> li2 = new ArrayList<String>();
		li2.addAll(prices);
		Collections.sort(prices);
		Collections.reverse(prices);
		boolean equals = prices.equals(li2);
		return equals;
	}

	/**
	 * 
	 * @return String
	 * @see Used to get success message for filter
	 */
	public String filterSuccessMsg() {
		String roomTypeSuccessMsg = elementGetText(getFilterRoomType());
		return roomTypeSuccessMsg;

	}

	/**
	 * 
	 * @return String
	 * @see Used to get success message after select hotel
	 */
	public String successMsgAfterSelectHotel() {
		String afterSelectHotel = elementGetText(getSuccessMsgAfterSelectHotel());
		return afterSelectHotel;
	}
}
