package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBasePOM;

public class LandingPage extends TestBasePOM {

	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	 WebElement loginButton;
	
	@FindBy(xpath="//span[contains(text(),'sign up')]")
	 WebElement signupButton;
	
	
	public LandingPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateTitle()
	{
		return driver.getTitle();
	
		
	}
	
	public String validateCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean validateloginButton()
	{
		 return loginButton.isDisplayed();
	}
	
	public boolean validateSignUpButton()
	{
		 return signupButton.isDisplayed();
	}
	
	public LoginPage loginClick() throws IOException
	{
		loginButton.click();
		
		return new LoginPage();
	}
}
