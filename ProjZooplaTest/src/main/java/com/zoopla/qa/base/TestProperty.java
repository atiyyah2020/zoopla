package com.zoopla.qa.base;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.zoopla.co.uk/for-sale/property/london/?q=london&results_sort=newest_listings&search_source=home");
		
		System.out.println("Data printed");
		
		List<Long> propPrice = new ArrayList<Long>();
		
		List<WebElement> list = driver.findElements(By.xpath("//*[starts-with(@id,'listing_57738')]/div[1]/div[1]/div[2]/div[1]/div/p"));
		for(int i=0; i < list.size();i++) {
			
			if(list.get(i).getText().contains("£")) {	
				System.out.println("Raw Amount "+list.get(i).getText());
				String rawPrice = list.get(i).getText();
				Long price=Long.parseLong(rawPrice.replace("£", "").replace(",", ""));
				System.out.println("Amount "+price);
				propPrice.add(price);				
				}
			
		}
		
		Actions action = new Actions(driver);
		action.moveToElement(list.get(4)).build().perform();
		list.get(4).click();
		
		Collections.sort(propPrice, Collections.reverseOrder());
		System.out.println("Printing Property price in Descending order:------>>");
		NumberFormat numFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		for(Long price:propPrice)
		{
			String currencyPrice=numFormat.format(price).toString();
			System.out.println(currencyPrice.substring(0, currencyPrice.indexOf(".")));
		}
		
		
		
		System.out.println("END");
		
	}

}
