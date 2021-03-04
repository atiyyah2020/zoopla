package com.zoopla.qa.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.LoginPage;
import com.zoopla.qa.pages.SigninPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	SigninPage signinPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		homepage.HomePageLogin();
		loginpage = new LoginPage();			
	}
	
	@Test(priority=2)
	public void loginpagetest() {
		signinPage = loginpage.Loadlogindata(pr.getProperty("username"), pr.getProperty("password"));
	}
	
	@Test(priority =1)
	public void loginpageTitletest() {
		String title = loginpage.verifyloginpageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Sign in to Zoopla - Zoopla");
	}
	
	
	@AfterMethod
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
	
}
