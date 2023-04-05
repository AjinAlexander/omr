
package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.datatable.DataTable;

/**
 * 
 * @author ajina 23-03-2023
 * @see Used to maintain the locators for BookHotelPage
 */
public class BookHotelPage extends BaseClass {


	/**
	 * @see Used to access the class properties to another class
	 */
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "own")
	private WebElement rdoBtnBookingFor;

	@FindBy(id = "user_title")
	private WebElement ddnTitle;

	@FindBy(id = "first_name")
	private WebElement txtFirstname;

	@FindBy(id = "last_name")
	private WebElement txtlastname;

	@FindBy(id = "user_phone")
	private WebElement txtPhoneNo;

	@FindBy(id = "user_email")
	private WebElement txtEmail;

	@FindBy(id = "gst")
	private WebElement chkBtnGst;

	@FindBy(id = "gst_registration")
	private WebElement txtRegisterNo;

	@FindBy(id = "company_name")
	private WebElement txtCompanyName;

	@FindBy(id = "company_address")
	private WebElement txtCompanyAdds;

	@FindBy(id = "step1next")
	private WebElement btnNext;

	@FindBy(id = "high")
	private WebElement chkRoomOnHighFloor;

	@FindBy(id = "other_request")
	private WebElement txtOtherRequest;

	@FindBy(id = "step2next")
	private WebElement btnNext1;

	@FindBy(id = "payment_type")
	private WebElement txtPaymentType;

	@FindBy(id = "card_type")
	private WebElement txtCardType;

	@FindBy(id = "card_no")
	private WebElement txtCardNo;

	@FindBy(id = "card_name")
	private WebElement txtCardName;

	@FindBy(id = "card_month")
	private WebElement txtCardMonth;

	@FindBy(id = "card_year")
	private WebElement txtCardYear;

	@FindBy(id = "cvv")
	private WebElement txtCvv;

	@FindBy(id = "submitBtn")
	private WebElement btnSubmit;

	@FindBy(xpath = "//h5[text()='UPI']")
	private WebElement btnUpiId;

	@FindBy(id = "upi_id")
	private WebElement txtUpiId;

	@FindBy(xpath = "//h5[text()='Credit/Debit/ATM Card']")
	private WebElement btnModeOfPayment;

	@FindBy(xpath = "//h2[text()='Book Hotel - HM Suites & Studios Standard']")
	private WebElement successMsgBookHotel;

	public WebElement getBtnUpiId() {
		return btnUpiId;
	}

	public WebElement getTxtUpiId() {
		return txtUpiId;
	}

	public WebElement getChkRoomOnHighFloor() {
		return chkRoomOnHighFloor;
	}

	public WebElement getTxtOtherRequest() {
		return txtOtherRequest;
	}

	public WebElement getBtnNext1() {
		return btnNext1;
	}

	public WebElement getBtnModeOfPayment() {
		return btnModeOfPayment;
	}

	public WebElement getTxtPaymentType() {
		return txtPaymentType;
	}

	public WebElement getTxtCardType() {
		return txtCardType;
	}

	public WebElement getTxtCardNo() {
		return txtCardNo;
	}

	public WebElement getTxtCardName() {
		return txtCardName;
	}

	public WebElement getTxtCardMonth() {
		return txtCardMonth;
	}

	public WebElement getTxtCardYear() {
		return txtCardYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getRdoBtnBookingFor() {
		return rdoBtnBookingFor;
	}

	public WebElement getDdnTitle() {
		return ddnTitle;
	}

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtPhoneNo() {
		return txtPhoneNo;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getChkBtnGst() {
		return chkBtnGst;
	}

	public WebElement getTxtRegisterNo() {
		return txtRegisterNo;
	}

	public WebElement getTxtCompanyName() {
		return txtCompanyName;
	}

	public WebElement getTxtCompanyAdds() {
		return txtCompanyAdds;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getSuccessMsgBookHotel() {
		return successMsgBookHotel;
	}

	/**
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param phoneNo
	 * @param email
	 * @param resgisterNo
	 * @param companyName
	 * @param companyAddress
	 * @param request
	 * @param paymentType
	 * @param cardType
	 * @param cardNo
	 * @param cardName
	 * @param cardMonth
	 * @param cardYear
	 * @param cvv
	 * @throws InterruptedException
	 * @see Used to book hotel with help of Debit/Credit card
	 */
	public void BookHotel(String title, String firstName, String lastName, String phoneNo, String email,
			String resgisterNo, String companyName, String companyAddress, String request, String cardType,
			DataTable dataTable) throws InterruptedException {
		addGuestDetails(title, firstName, lastName, phoneNo, email);
		addGstDetails(resgisterNo, companyName, companyAddress);
		addSpecialRequest(request);
		addCardPaymentDetails(cardType, dataTable);

	}

	/**
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param phoneNo
	 * @param email
	 * @param resgisterNo
	 * @param companyName
	 * @param companyAddress
	 * @param request
	 * @param upiId
	 * @throws InterruptedException
	 * @see Used to book hotel with help of upiId
	 */
	public void BookHotel(String title, String firstName, String lastName, String phoneNo, String email,
			String resgisterNo, String companyName, String companyAddress, String request, String upiId)
			throws InterruptedException {
		addGuestDetails(title, firstName, lastName, phoneNo, email);
		addGstDetails(resgisterNo, companyName, companyAddress);
		addSpecialRequest(request);
		addPaymentUpi(upiId);

	}

	/**
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param phoneNo
	 * @param email
	 * @throws InterruptedException
	 * @ Used to Add guest details
	 */
	public void addGuestDetails(String title, String firstName, String lastName, String mobileNo, String email)
			throws InterruptedException {
		Thread.sleep(3000);
		elementClick(getRdoBtnBookingFor());
		selectByText(getDdnTitle(), title);
		elementSendkeys(getTxtFirstname(), firstName);
		elementSendkeys(getTxtlastname(), lastName);
		elementSendkeys(getTxtPhoneNo(), mobileNo);
		elementSendkeys(getTxtEmail(), email);

	}

	/**
	 * 
	 * @param resgisterNo
	 * @param companyName
	 * @param companyAddress
	 * @ Used to Add GST details
	 */
	public void addGstDetails(String resgisterNo, String companyName, String companyAddress) {
		elementClick(getChkBtnGst());
		elementSendkeys(getTxtRegisterNo(), resgisterNo);
		elementSendkeys(getTxtCompanyName(), companyName);
		elementSendkeys(getTxtCompanyAdds(), companyAddress);
		elementClick(getBtnNext());
	}

	/**
	 * 
	 * @param request
	 * @ Used to add the special Request
	 */
	public void addSpecialRequest(String request) {
		elementClick(getChkRoomOnHighFloor());
		elementSendkeys(getTxtOtherRequest(), request);
		elementClick(getBtnNext1());

	}

	/**
	 * 
	 * @param paymentType
	 * @param cardType
	 * @param cardNo
	 * @param cardName
	 * @param cardMonth
	 * @param cardYear
	 * @param cvv
	 * @throws InterruptedException
	 * @see Used to add the Card payment details for debit card
	 */
	public void addCardPaymentDetails(String cardType, DataTable dataTable) {
		implicityWait();
		elementClick(getBtnModeOfPayment());
		elementSendkeys(getTxtPaymentType(), cardType);
		List<Map<String, String>> debit = dataTable.asMaps();
		Map<String, String> e = debit.get(0);
		String c = e.get("selectCard");
		String no = e.get("cardNo");
		String name = e.get("cardName");
		String mon = e.get("cardMonth");
		String yr = e.get("cardYear");
		String cv = e.get("cvvNo");
		implicityWait();
		elementSendkeys(getTxtCardType(), c);
		elementSendkeys(getTxtCardNo(), no);
		elementSendkeys(getTxtCardName(), name);
		elementSendkeys(getTxtCardMonth(), mon);
		selectByText(getTxtCardYear(), yr);
		elementSendkeysjs(getTxtCvv(), cv);
		elementClick(getBtnSubmit());
	}

	/**
	 * 
	 * @param upiId
	 * @see Used to add payment for upi id
	 */
	public void addPaymentUpi(String upiId) {
		elementClick(getBtnUpiId());
		elementSendkeys(getTxtUpiId(), upiId);
		submitButton();
	}

	/**
	 * @see Used to click alert
	 */
	public void bookingPageAccept() {
		alertOk();
	}

	/**
	 * @see Used to click the button
	 */
	public void submitButton() {
		elementClick(getBtnSubmit());
	}

	/**
	 * 
	 * @return String
	 * @see Used to get success message book hotel
	 */
	public static String hotelName;
	public String successAfterBookHotel() {
		String actBookHotelSuccessMsg = elementGetText(getSuccessMsgBookHotel());
		hotelName = actBookHotelSuccessMsg;
		return actBookHotelSuccessMsg;
	}

}
