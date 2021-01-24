package com.blazedemo.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.qa.base.TestBase;

public class ReservePage extends TestBase {

	@FindBy(css = "input[value='Choose This Flight']")
	private WebElement chooseThisFlight;
	
	@FindBy(xpath = "//table[@class='table']//th")
	private List<WebElement> searchResultsHeader;
	
	public ReservePage() {

		PageFactory.initElements(driver, this);

	}

	public PurchasePage clickChooseThisFlight()
	{
		chooseThisFlight.click();
		return new PurchasePage();
	}
	
	
	public ArrayList<String>getSearchResultsHeader()
	{
		List<WebElement> headers = searchResultsHeader;
        Iterator<WebElement> headersIterator=headers.iterator();
        ArrayList<String> actualHeaders = new ArrayList<String>();
        while(headersIterator.hasNext())
        {
        	actualHeaders.add(headersIterator.next().getText());
        }
        return actualHeaders;
		
		
	}
	
}
