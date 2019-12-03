package com.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.PomUtil;

public class TestBasePOM {
	
	public static WebDriver driver;
	
	public static Properties prop;
	 
	
	public TestBasePOM() throws IOException
	{
		 
		try {
			
			  prop = new Properties();
			
			 FileInputStream file= new FileInputStream("C:\\Users\\vt1056.SRITADS\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\com\\qa\\config\\config.properties");
			   
			   prop.load(file);
			  			
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	  
	public static void intialization() throws InterruptedException
	{
		
		String browserName = prop.getProperty("browser");
		
		 System.out.println(browserName);
		 
		  if(browserName.equals("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\vt1056.SRITADS\\Downloads\\chromedriver_win32\\chromedriver.exe");
			  
			   driver= new ChromeDriver();
			   
		  }
		  
		  else
		  {
			  System.setProperty("webdriver.gecko.driver", "C:\\Users\\vt1056.SRITADS\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			  
			   driver= new FirefoxDriver();
		  }
	
		   
		  driver.manage().window().maximize();
		  
		   driver.manage().deleteAllCookies();
		   
		   driver.manage().timeouts().pageLoadTimeout(PomUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		   
		   driver.manage().timeouts().implicitlyWait(PomUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		   
		   driver.get(prop.getProperty("url"));
		   
		    Thread.sleep(4000);
	
	}
	  

}
