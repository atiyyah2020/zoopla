package com.zoopla.qa.pages;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class PropPage extends TestBase {
	
	public PropPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='css-1e28vvi-PriceContainer e2uk8e8']/p")
	List<WebElement> propAmount;
	
	@FindBy(xpath="//div[@class='css-zays2g-ImageContainer e2uk8e24']//div//a//img")
	List<WebElement> imageList;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement imageSearch;
	
	public void properySearch() {
		imageSearch.click();
	}
		
	public void PropertyAmount() {
		
		List<Long> priceList  = new ArrayList<Long>(); 
		for (int i=0;i<propAmount.size();i++) {
			String rawpriceVal = propAmount.get(i).getText();
			System.out.println(rawpriceVal);
			if( rawpriceVal.contains("£")) {
				Long rawPrice = Long.parseLong(rawpriceVal.replace("£", "").replace(",", ""));
				priceList.add(rawPrice);
			}
			
		}
		
		Collections.sort(priceList,Collections.reverseOrder());
		System.out.println("Printing Property price in Descending order:------>>");
		NumberFormat numberformat = NumberFormat.getCurrencyInstance(Locale.UK);
		for (Long price:priceList) {
			String ukPrice =numberformat.format(price).toString();
			System.out.println(ukPrice);
		}
		
		//	System.out.println(currencyPrice.substring(0, currencyPrice.indexOf(".")));
		
	}
	
	
	public SaleDetailPage Select5property (int propNum) {
		
		System.out.println("List of images found "+imageList.size());
		for(int i=0;i <imageList.size();i++) {
			System.out.println("i= "+i);
			if ((propNum-1)==i) {
				Actions action = new Actions(driver);
				action.moveToElement(imageList.get(i)).build().perform();
				imageList.get(i).click();
				break;								
			}			
		}
		return new SaleDetailPage();
	}
	
	
	
	
	
}
