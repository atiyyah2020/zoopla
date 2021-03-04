package com.zoopla.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath ="/html/body/div[2]/div/div/div/header/div/div/div[1]/div/ul/li[2]/a")
	WebElement signIn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage HomePageLogin() {
		signIn.click();
		return new LoginPage();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
		
	}
	
	
}
