package com.blazedemo.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.blazedemo.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(name = "fromPort")
	private WebElement fromCityDropdown;

	@FindBy(name = "toPort")
	private WebElement toCityDropdown;

	@FindBy(css = "input[value='Find Flights']")
	private WebElement submitBTN;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectSourceAndDestination(String sourceCity, String destinationCity) {
		Select fromCity = new Select(fromCityDropdown);
		fromCity.selectByValue(sourceCity);

		Select toCity = new Select(toCityDropdown);
		toCity.selectByValue(destinationCity);

	}

	public ReservePage clickSubmit() {
		submitBTN.click();
		return new ReservePage();

	}

	public ArrayList<String> getFromPortNames() {
		Select fromCity = new Select(fromCityDropdown);
		List<WebElement> fromCityList = fromCity.getOptions();
        Iterator<WebElement> fromCityIterator=fromCityList.iterator();
        ArrayList<String> actualFromCities = new ArrayList<String>();
        while(fromCityIterator.hasNext())
        {
        	actualFromCities.add(fromCityIterator.next().getText());
        }
        return actualFromCities;
	}
	
	public ArrayList<String> getToPortNames() {
		Select toCity = new Select(toCityDropdown);
		List<WebElement> toCityList = toCity.getOptions();
        Iterator<WebElement> toCityIterator=toCityList.iterator();
        ArrayList<String> actualToCities = new ArrayList<String>();
        while(toCityIterator.hasNext())
        {
        	actualToCities.add(toCityIterator.next().getText());
        }
        return actualToCities;
	}

}
