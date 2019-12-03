package com.qa.stepDefinition;

import java.io.IOException;
import java.util.Map;

import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBasePOM;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class POMStepDefinition extends TestBasePOM {
	
	public POMStepDefinition() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	

	

	@Given("^user in landing page$")
	public void user_in_landing_page() throws InterruptedException  {
	    
		TestBasePOM.intialization();
	}

	@When("^title is Free Crm$")
	public void title_is_Free_Crm() throws IOException  {
		
		landingpage = new LandingPage();
	    
		String title = landingpage.validateTitle();
		 System.out.println("The tile of the page is:"+title);
	}

	@Then("^validate current url$")
	public void validate_current_url()  {
		
		String currentUrl = landingpage.validateCurrentUrl();
		   System.out.println("The tile of the page is:"+currentUrl);
		
	}

	@Then("^validate the login button$")
	public void validate_the_login_button()  {
	   
		boolean b =landingpage.validateloginButton();
		
		Assert.assertTrue(b);
	}

	@Then("^validate the sign up button$")
	public void validate_the_sign_up_button()  {
	   
		boolean b =landingpage.validateSignUpButton();
		 Assert.assertTrue(b);
	}

	@Then("^click on login button$")
	public void click_on_login_button() throws IOException {
	
	     loginpage= landingpage.loginClick();
	}

	@Then("^closes the browser$")
	public void closes_the_browser() {
	   
		driver.quit();
	}

	@Given("^user in login page$")
	public void user_in_login_page() throws InterruptedException, IOException {
	   
		TestBasePOM.intialization();
		
		
		landingpage =new LandingPage();

		landingpage.loginClick();
		  Thread.sleep(4000);
		
		
	}

	@Then("^user enters email and password$")
	public void user_enters_email_and_password() throws InterruptedException, IOException  {
		
		loginpage= new LoginPage();
		
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		
	}

	@Then("^user is in homepage$")
	public void user_is_in_homepage() {
	   
		String title = driver.getTitle();
		
		 System.out.println(title);
		
	}

	@Then("^verify username$")
	public void verify_username() {
	    
		String user = loginpage.validateUserName();
		 System.out.println(user);
	}

	@Then("^close the browser$")
	public void close_the_browser() {
	    
		driver.quit();
	}

    
	@Given("^user in homepage$")
	public void user_in_homepage() throws InterruptedException, IOException {
	    
		TestBasePOM.intialization();
		
		landingpage = new LandingPage();
		
		landingpage.loginClick();
		
		loginpage = new LoginPage();
		
		homepage = new HomePage();
		
		
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	
		
		
	}

	@Then("^click on contact link$")
	public void click_on_contact_link() throws InterruptedException  {
		
		homepage.validateContactLink();
	    
	}

	@Then("^click on add contact$")
	public void click_on_add_contact() throws InterruptedException {
	   
		homepage.validateAddNewButton();
	}

	@Then("^enters firstname and lastname$")
	public void enters_firstname_and_lastname() throws InterruptedException  {
	    
		homepage.sendDetails(prop.getProperty("firstname"), prop.getProperty("lastname"));
	}

	@Then("^closing the browser$")
	public void closing_the_browser(){
	    
		driver.quit();
	}



}
