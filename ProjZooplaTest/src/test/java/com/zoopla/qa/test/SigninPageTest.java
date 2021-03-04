package com.zoopla.qa.test;

import java.sql.Driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.LoginPage;
import com.zoopla.qa.pages.SigninPage;

public class SigninPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	SigninPage singinpage;
	
	public SigninPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		homepage.HomePageLogin();
		loginpage = new LoginPage();
		loginpage.Loadlogindata( pr.getProperty("username"), pr.getProperty("password"));
		singinpage = new SigninPage();
	}
	
	@Test
	public void siginpageloginTest() {
		singinpage.setLocationName("W11 1LE");
		singinpage.setChoice("£10,000", "£200,000", "Houses", "3+");
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			//driver.quit();
		}
	}
	
	
}
