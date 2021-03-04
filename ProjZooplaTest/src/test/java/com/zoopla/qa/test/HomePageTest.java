package com.zoopla.qa.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test(priority=1)
	public void homepageTitleTest() {
		String title = homepage.validatePageTitle();
		assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	}
	
	@Test(priority=2)
	public void  homepageloginTest() {
		loginpage = homepage.HomePageLogin();	
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		if (driver!=null) {
				driver.quit();
		}
	}
	
}
