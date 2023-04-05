package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author ajina 23-03-2023
 * @see Used to maintain the locators for ExploreHotelPage
 */
public class ExploreHotelPage extends BaseClass {

	/**
	 * @see Used to access the class properties to another class
	 */
	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "state")
	private WebElement ddnState;

	@FindBy(xpath = "//span[text()='Select City *']")
	private WebElement btnCity;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement ddnField;

	@FindBy(xpath = "//textarea[contains(@class,'select2-search__field')]")
	private WebElement ddnRoomtype;

	@FindBy(xpath = "//input[@name='check_in']")
	private WebElement txtCheckin;

	@FindBy(xpath = "//input[@name='check_out']")
	private WebElement txtCheckout;

	@FindBy(id = "no_rooms")
	private WebElement ddnNoRooms;

	@FindBy(id = "no_adults")
	private WebElement ddnNoAdults;

	@FindBy(id = "no_child")
	private WebElement txtNoChild;

	@FindBy(xpath = "//iframe[@id='hotelsearch_iframe']")
	private WebElement switchToFrame;

	@FindBy(id = "searchBtn")
	private WebElement btnSearch;

	@FindBy(id = "invalid-state")
	private WebElement error1;

	@FindBy(id = "invalid-city")
	private WebElement error2;

	@FindBy(id = "invalid-check_in")
	private WebElement error3;

	@FindBy(id = "invalid-check_out")
	private WebElement error4;

	@FindBy(id = "invalid-no_rooms")
	private WebElement error5;

	@FindBy(id = "invalid-no_adults")
	private WebElement error6;

	@FindBy(xpath = "//a[@class='icoTwitter mr-2 dropdown-toggle']")
	private WebElement loginSuccessMessagelogin;

	@FindBy(xpath = "//li[contains(@class,'results__option--highlighted')]")
	private WebElement optionsClick;

	public WebElement getError1() {
		return error1;
	}

	public WebElement getError2() {
		return error2;
	}

	public WebElement getError3() {
		return error3;
	}

	public WebElement getError4() {
		return error4;
	}

	public WebElement getError5() {
		return error5;
	}

	public WebElement getError6() {
		return error6;
	}

	public WebElement getLoginSuccessMessagelogin() {
		return loginSuccessMessagelogin;
	}

	public WebElement getDdnState() {
		return ddnState;
	}

	public WebElement getBtnCity() {
		return btnCity;
	}

	public WebElement getDdnField() {
		return ddnField;
	}

	public WebElement getDdnRoomtype() {
		return ddnRoomtype;
	}

	public WebElement getTxtCheckin() {
		return txtCheckin;
	}

	public WebElement getTxtCheckout() {
		return txtCheckout;
	}

	public WebElement getDdnNoRooms() {
		return ddnNoRooms;
	}

	public WebElement getDdnNoAdults() {
		return ddnNoAdults;
	}

	public WebElement getTxtNoChild() {
		return txtNoChild;
	}

	public WebElement getSwitchToFrame() {
		return switchToFrame;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	/**
	 * 
	 * @param state
	 * @param field
	 * @param checkin
	 * @param checkout
	 * @param noRooms
	 * @param noAdults
	 * @see Used for explore hotel common steps
	 */
	public void exploreHotelsCommonSteps(String state, String field, String checkin, String checkout, String no_room,
			String no_adult) {
		elementSendkeys(getDdnState(), state);
		elementClick(getBtnCity());
		elementWithEnterKey(getDdnField(), field);
		elementSendkeysjs(getTxtCheckin(), checkin);
		elementSendkeysjs(getTxtCheckout(), checkout);
		elementSendkeys(getDdnNoRooms(), no_room);
		elementSendkeys(getDdnNoAdults(), no_adult);
	}

	// ul[@id='select2-room_type-container']
	/**
	 * 
	 * @param state
	 * @param field
	 * @param roomType
	 * @param checkin
	 * @param checkout
	 * @param noRooms
	 * @param noAdults
	 * @param noChild
	 * @throws InterruptedException
	 * @see Used for explore all field and search hotel
	 */
	public void exploreHotels(String state, String field, String roomType, String checkin, String checkout,
			String no_room, String no_adult, String no_child) {
		exploreHotelsCommonSteps(state, field, checkin, checkout, no_room, no_adult);
		implicityWait();
		sendKeysUsingSplit(getDdnRoomtype(), roomType);
		elementSendkeys(getTxtNoChild(), no_child);
		clickSearchHotel();

	}

	/**
	 * 
	 * @param state
	 * @param field
	 * @param checkin
	 * @param checkout
	 * @param noRooms
	 * @param noAdults
	 * @see Used for mandatory field and search hotel
	 */
	public void explorehotels(String state, String field, String checkin, String checkout, String noRooms,
			String noAdults) {
		exploreHotelsCommonSteps(state, field, checkin, checkout, noRooms, noAdults);
		clickSearchHotel();
	}

	/**
	 * @Used for click the search button
	 */
	public void clickSearchHotel() {
		switchDefaultFrame();
		switchFrame(getSwitchToFrame());
		elementClick(getBtnSearch());
	}
/**
 * 
 * @return
 * @see Used to get login success messsage
 */
	public String getLoginSuccessMsg() {
		String actLoginSuccessMsg = elementGetText(getLoginSuccessMessagelogin());
		return actLoginSuccessMsg;
	}
/**
 * 
 * @return String
 * @see Used to get 1st error 
 */
	public String error1() {
		switchDefaultFrame();
		String actError1Msg = elementGetText(getError1());

		return actError1Msg;
	}
	/**
	 * 
	 * @return String
	 * @see Used to get 2nd error 
	 */
	public String error2() {
		String actError2Msg = elementGetText(getError2());

		return actError2Msg;
	}
	/**
	 * 
	 * @return String
	 * @see Used to get 3rd error 
	 */
	public String error3() {
		String actError3Msg = elementGetText(getError3());

		return actError3Msg;
	}
	/**
	 * 
	 * @return String
	 * @see Used to get 4th error 
	 */
	public String error4() {
		String actError4Msg = elementGetText(getError4());

		return actError4Msg;
	}
	/**
	 * 
	 * @return String
	 * @see Used to get 5th error 
	 */
	public String error5() {
		String actError5Msg = elementGetText(getError5());

		return actError5Msg;
	}
	/**
	 * 
	 * @return String
	 * @see Used to get 6th error 
	 */
	public String error6() {
		String actError6Msg = elementGetText(getError6());

		return actError6Msg;

	}
/**
 * 
 * @param element
 * @param data
 * @see Used to send key using Split
 */
	public void sendKeysUsingSplit(WebElement element, String data) {
		String[] dataArray = data.split("/");
		for (int i = 0; i < dataArray.length; i++) {
			element.sendKeys(dataArray[i]);
			optionsClick.click();

		}

	}
}