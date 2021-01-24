package com.blazedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.qa.base.TestBase;

public class ConfirmationPage extends TestBase {

	@FindBy(xpath = "//td[text()='Id']/following-sibling::td")
	private WebElement bookingId;

	public ConfirmationPage() {

		PageFactory.initElements(driver, this);

	}

	public String getBookingId() {

		return bookingId.getText();

	}
	
	
}
