package com.blazedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.blazedemo.qa.base.TestBase;

public class PurchasePage extends TestBase {

	@FindBy(id = "inputName")
	private WebElement passengerName;

	@FindBy(id = "address")
	private WebElement passengerAddress;

	@FindBy(id = "city")
	private WebElement passengerCity;

	@FindBy(id = "state")
	private WebElement passengerState;

	@FindBy(id = "zipCode")
	private WebElement passengerZipCode;

	@FindBy(id = "cardType")
	private WebElement creditCardType;

	@FindBy(id = "creditCardNumber")
	private WebElement creditCardNumber;

	@FindBy(id = "creditCardMonth")
	private WebElement creditCardMonth;

	@FindBy(id = "creditCardYear")
	private WebElement creditCardYear;

	@FindBy(id = "nameOnCard")
	private WebElement creditCardName;

	@FindBy(css = "input[value='Purchase Flight']")
	private WebElement chooseThisFlight;

	public PurchasePage() {
		PageFactory.initElements(driver, this);
	}

	public void providePassengerDetail(String Name, String Address, String City, String State, String ZipCode)

	{
		passengerName.sendKeys(Name);
		passengerAddress.sendKeys(Address);
		passengerCity.sendKeys(City);
		passengerState.sendKeys(State);
		ZipCode = ZipCode.replaceAll(".0", "");
		passengerZipCode.sendKeys(ZipCode);

	}

	public void provideCardDetail(String carddype, String cardNumber, String cardMonth, String cardYear,
			String cardName)

	{
		creditCardMonth.clear();
		creditCardYear.clear();

		cardYear = cardYear.substring(0, cardYear.length() - 2);
		cardMonth = cardMonth.substring(0, cardMonth.length() - 2);

		cardNumber = cardNumber.replaceAll("\\s", "");
		Select cardType = new Select(creditCardType);
		cardType.selectByVisibleText(carddype);

		creditCardNumber.sendKeys(cardNumber);
		creditCardMonth.sendKeys(cardMonth);
		creditCardYear.sendKeys(cardYear);
		creditCardName.sendKeys(cardName);

	}

	public ConfirmationPage clickPurchaseFlight() {

		chooseThisFlight.submit();
		return new ConfirmationPage();
	}
	
	public boolean isFirstNameTextFieldPresent()
	{
		return passengerName.isDisplayed();
	}
	
	public boolean isPassengerAddressTextFieldPresent()
	{
		return passengerAddress.isDisplayed();
	}

	
	public boolean isCityTextFieldPresent()
	{
		return passengerCity.isDisplayed();
	}

	public boolean isZipCodeTextFieldPresent()
	{
		return passengerZipCode.isDisplayed();
	}
	
	public boolean isStateTextFieldPresent()
	{
		return passengerState.isDisplayed();
	}
	
	public boolean isCardTypeDropDownPresent()
	{
		return creditCardType.isDisplayed();
	}
	
	public boolean isCardYearTextFieldPresent()
	{
		return creditCardYear.isDisplayed();
	}
	
	public boolean isCardMonthTextFieldPresent()
	{
		return creditCardMonth.isDisplayed();
	}
	
	public boolean isCardNumberTextFieldPresent()
	{
		return creditCardNumber.isDisplayed();
	}

	public boolean isNameOnCardTextFieldPresent()
	{
		return creditCardName.isDisplayed();
	}

}
