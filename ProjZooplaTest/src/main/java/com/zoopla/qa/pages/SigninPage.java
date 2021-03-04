package com.zoopla.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zoopla.qa.base.TestBase;

public class SigninPage extends TestBase {
	
	
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath= "//a[@id='search-tabs-to-rent']")
	//WebElement lnktoRent;
	
	@FindBy(id = "search-input-location")
	WebElement txtgeoidentifier;
	
	@FindBy(id= "forsale_price_min")
	WebElement lstpriceMin;
	
	@FindBy(id= "forsale_price_max")
	WebElement lstpriceMax;
	
	@FindBy(id= "property_type")
	WebElement lstpropType;
	
	@FindBy(id= "beds_min")
	WebElement lstbedMinx;

	@FindBy(xpath= "//button[@id='search-submit']")
	WebElement btnSubmit;

	
	public void setLocationName(String GeoName) {
		//lnktoRent.click();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("document.getElementsByName('geo_autocomplete_identifier')[0].value=('BIRMINGHAM')");
				
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].value='B11';", txtgeoidentifier);
		txtgeoidentifier.clear();
		//txtgeoidentifier.click();
		txtgeoidentifier.sendKeys(GeoName);		
	}
	
	public PropPage setChoice(String minVal,String MaxVal, String propType, String BedMin) {
		Select selectMin = new Select(lstpriceMin); 
		//selectMin.selectByValue(minVal);
		selectMin.selectByIndex(1);
		
		Select selectMax = new Select(lstpriceMax); 
		//selectMax.selectByValue(MaxVal);
		selectMax.selectByIndex(40);
		
		Select selectType = new Select(lstpropType); 
		//selectType.selectByValue(propType);
		selectType.selectByIndex(0);
		
		Select selectBed = new Select(lstbedMinx); 
		//selectBed.selectByValue(BedMin);
		selectBed.selectByIndex(2);
		
		btnSubmit.click();
		return new PropPage();
		
	}
	
	
	
	
	
}
