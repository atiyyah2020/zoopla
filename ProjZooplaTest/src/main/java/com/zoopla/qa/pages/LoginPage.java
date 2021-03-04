package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "signin_email")
	WebElement signinEmail;
	
	@FindBy(id = "signin_password")
	WebElement signinPassword;
	
	@FindBy(xpath = "//button[@id='signin_submit']")
	WebElement btnSignIn;
	
	public SigninPage Loadlogindata(String email, String Passowrd) {
		signinEmail.sendKeys(email);
		signinPassword.sendKeys(Passowrd);
		btnSignIn.click();
		return new SigninPage();
	}
	
	public String verifyloginpageTitle() {
		return driver.getTitle();
	}
}
