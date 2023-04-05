package com.pagemanager;

import com.pages.BookHotelPage;

import com.pages.BookingConfirmationPage;
import com.pages.ExploreHotelPage;
import com.pages.LoginPage;
import com.pages.MyBookingPage;
import com.pages.SelectHotelPage;

/**
 * @author ajina @ 22-03-2023
 * @see If the object is not create,create the object and return and If object
 *      is created,return the created object
 */

public class PageObjectManager {

	private LoginPage loginPage;
	private ExploreHotelPage exploreHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private MyBookingPage myBookingPage;

	/**
	 * 
	 * @return LoginPage
	 * @see If the object is not create for LoginPage,create the object and return
	 *      and If object is created,return the created object
	 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	/**
	 * 
	 * @return ExploreHotelPage
	 * @see If the object is not create for ExploreHotelPage,create the object and
	 *      return and If object is created,return the created object
	 */
	public ExploreHotelPage getExploreHotelPage() {
		return (exploreHotelPage == null) ? exploreHotelPage = new ExploreHotelPage() : exploreHotelPage;
	}

	/**
	 * 
	 * @return SelectHotelPage
	 * @see If the object is not create for SelectHotelPage,create the object and
	 *      return and If object is created,return the created object
	 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}

	/**
	 * 
	 * @return BookHotelPage
	 * @see If the object is not create for BookHotelPage,create the object and
	 *      return and If object is created,return the created object
	 */
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}

	/**
	 * 
	 * @return BookingConfirmationPage
	 * @see If the object is not create for BookingConfirmationPage,create the
	 *      object and return and If object is created,return the created object
	 */
	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage == null) ? bookingConfirmationPage = new BookingConfirmationPage()
				: bookingConfirmationPage;
	}

	/**
	 * 
	 * @return MyBookingPage
	 * @see If the object is not create for MyBookingPage,create the object and
	 *      return and If object is created,return the created object
	 */
	public MyBookingPage getMyBookingPage() {
		return (myBookingPage == null) ? myBookingPage = new MyBookingPage() : myBookingPage;
	}

}
