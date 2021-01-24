package com.blazedemo.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pages.ConfirmationPage;
import com.blazedemo.qa.pages.HomePage;
import com.blazedemo.qa.pages.PurchasePage;
import com.blazedemo.qa.pages.ReservePage;

import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class SmokeSuite extends TestBase {

	HomePage homePage = null;
	ReservePage reservePage = null;
	PurchasePage purchasePage = null;
	ConfirmationPage confirmationPage = null;

	public SmokeSuite() {
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
	
	@Test(groups= {"smoke"})
	public void validateFromCitiesDropdown()
	{
		ArrayList<String> expectedFromCities = new ArrayList<String>(Arrays.asList("Paris","Philadelphia","Boston","Portland","San Diego","Mexico City","São Paolo"));
		ArrayList<String> actualFromCities=homePage.getFromPortNames();

		//Asserting cities in Actual and Expected List are same.
		Assert.assertTrue(actualFromCities.equals(expectedFromCities));
		
	}
	
	@Test(groups= {"smoke"})
	public void validateToCitiesDropdown()
	{
		ArrayList<String> expectedToCities = new ArrayList<String>(Arrays.asList("Buenos Aires","Rome","London","Berlin","New York","Dublin","Cairo"));
		ArrayList<String> actualToCities=homePage.getToPortNames();

		//Asserting cities in Actual and Expected List are same.
		Assert.assertTrue(actualToCities.equals(expectedToCities));
		
	}

	@Test(groups= {"smoke"})
	public void validateSearchResultsHeader()
	{
		String fromPort = "San Diego";
		String toPort="Rome";
		
		homePage.selectSourceAndDestination(fromPort, toPort);
		reservePage = homePage.clickSubmit();
		
		ArrayList<String> expectedHeader = new ArrayList<String>(Arrays.asList("Choose","Flight #","Airline","Departs: "+fromPort,"Arrives: "+toPort,"Price"));
		ArrayList<String> actualHeader=reservePage.getSearchResultsHeader();

		//Asserting Headers in Actual and Expected List are same.
	    Assert.assertTrue(actualHeader.equals(expectedHeader));
		
	}
	
	@Test(groups= {"smoke"})
	public void validateUIElementsOfPurchasePage()
	{
		
		String fromPort = "San Diego";
		String toPort="Rome";
		
		homePage.selectSourceAndDestination(fromPort, toPort);
		reservePage = homePage.clickSubmit();
		
		// Click "Choose This Flight" Button
		purchasePage = reservePage.clickChooseThisFlight();
		
		Assert.assertTrue(purchasePage.isFirstNameTextFieldPresent());
		Assert.assertTrue(purchasePage.isPassengerAddressTextFieldPresent());
		Assert.assertTrue(purchasePage.isCityTextFieldPresent());
		Assert.assertTrue(purchasePage.isStateTextFieldPresent());
		Assert.assertTrue(purchasePage.isZipCodeTextFieldPresent());
		
		Assert.assertTrue(purchasePage.isCardTypeDropDownPresent());
		Assert.assertTrue(purchasePage.isCardNumberTextFieldPresent());
		Assert.assertTrue(purchasePage.isCardMonthTextFieldPresent());
		Assert.assertTrue(purchasePage.isNameOnCardTextFieldPresent());
		
	}
	
}
