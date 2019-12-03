package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBasePOM;

public class LoginPage extends TestBasePOM {
	
	@FindBy(xpath="//input[@placeholder='E-mail address']")
	 WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	 WebElement password;
	 
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	 WebElement submit;
	
	@FindBy(xpath="//span[@class='user-display']")
	 WebElement username;
	
	
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException
	{
		email.sendKeys(un);
		 Thread.sleep(4000);
		
		password.sendKeys(pwd);
		 Thread.sleep(4000);
		 
		 submit.click();
		  Thread.sleep(3000);
		  
		   return new HomePage();
		   
	}
	
	public String validateUserName()
	{
		 return username.getText();
	}
	
}
