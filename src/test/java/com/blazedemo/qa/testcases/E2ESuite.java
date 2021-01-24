package com.blazedemo.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pages.ConfirmationPage;
import com.blazedemo.qa.pages.HomePage;
import com.blazedemo.qa.pages.PurchasePage;
import com.blazedemo.qa.pages.ReservePage;
import com.blazedemo.qa.util.TestUtil;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class E2ESuite extends TestBase {

	HomePage homePage = null;
	ReservePage reservePage = null;
	PurchasePage purchasePage = null;
	ConfirmationPage confirmationPage = null;

	public E2ESuite() {
		super();
	}

	// Object Reference for all the POs are initialized.
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialize();
		homePage = new HomePage();
		reservePage = new ReservePage();
		purchasePage = new PurchasePage();
		confirmationPage = new ConfirmationPage();
	}

	// Closing the driver after each test.
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	// Data Provider to fetch Data from Excel
	@DataProvider
	public Iterator<Object[]> getE2EData() {
		ArrayList<Object[]> testData = TestUtil.getTestData();
		return testData.iterator();

	}

	@Test(groups= {"E2E"},dataProvider = "getE2EData")
	public void bookTicket(String fromPort, String toPort, String passengerName, String passengerAddress,
			String passengerState, String passengerCity, String passengerZipCode, String cardType, String cardMonth,
			String cardYear, String cardName, String cardNumber) {

		// Selecting Source and Destination Port.
		homePage.selectSourceAndDestination(fromPort, toPort);
		reservePage = homePage.clickSubmit();

		// Click "Choose This Flight" Button
		purchasePage = reservePage.clickChooseThisFlight();

		// Providing the Passenger Details
		purchasePage.providePassengerDetail(passengerName, passengerAddress, passengerState, passengerCity,
				passengerZipCode);
		purchasePage.provideCardDetail(cardType, cardNumber, cardMonth, cardYear, cardName);
		
		//Click "Purchase Flight" Button
		confirmationPage = purchasePage.clickPurchaseFlight();

		//Asserting BookingId is not null
		String BookingId = confirmationPage.getBookingId();
		Assert.assertTrue(!BookingId.isEmpty());
	}

}
