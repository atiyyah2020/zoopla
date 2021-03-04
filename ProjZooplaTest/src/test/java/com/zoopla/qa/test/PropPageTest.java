package com.zoopla.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.LoginPage;
import com.zoopla.qa.pages.PropPage;
import com.zoopla.qa.pages.SigninPage;

public class PropPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	SigninPage singinpage;
	PropPage proppage;
		
	
	
	public PropPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();		
		homepage.HomePageLogin();
		
		loginpage = new LoginPage();
		loginpage.Loadlogindata(pr.getProperty("username"), pr.getProperty("password"));
		
		singinpage = new SigninPage();		
		singinpage.setLocationName("W11 1LE");
		singinpage.setChoice("£10,000", "£200,000", "Houses", "3+");
		
		
		proppage = new PropPage();
		
	}
	
	@Test(priority=1)
	public void propPageAmountlistTest() throws InterruptedException {
		Thread.sleep(1000);
		proppage.properySearch();		
		proppage.PropertyAmount();
	}
	
	@Test(priority=2)
	public void propPageclickTest() throws InterruptedException {
		Thread.sleep(1000);
		proppage.properySearch();		
		proppage.Select5property(5);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}
	
	




}
