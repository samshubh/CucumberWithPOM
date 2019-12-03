package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBasePOM;

public class HomePage extends TestBasePOM {
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	 WebElement contactLink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	 WebElement newAddButton;
	
	@FindBy(xpath="//input[@name='first_name']")
	 WebElement firstName ;
	
	@FindBy(xpath="//input[@name='last_name']")
	 WebElement lastName ;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	  WebElement saveButton;


	public HomePage() throws IOException {
		
		PageFactory.initElements(driver,this);
	}
	
	
	public void validateContactLink() throws InterruptedException
	{
		contactLink.click();
		 Thread.sleep(4000);
	}
	
	public void validateAddNewButton() throws InterruptedException
	{
		newAddButton.click();
		 Thread.sleep(3000);
	}
	
    public void sendDetails(String fname,String lname) throws InterruptedException
    {
    	firstName.sendKeys(fname);
    	  Thread.sleep(3000);
    	  
    	  lastName.sendKeys(lname);
    	   Thread.sleep(3000);
    	   
    	   saveButton.click();
    	    Thread.sleep(3000);
    	  
    	
    }
}
