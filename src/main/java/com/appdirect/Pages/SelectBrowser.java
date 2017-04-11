package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class SelectBrowser{
	
	WebDriver driver=null;
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	public WebDriver browser1() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
		prop=readfromfile.getProp();
	
		String browser = prop.getProperty("chromebrowser_name");
		
		
	    if(browser.equalsIgnoreCase("firefoxbrowser"))
		{
//	    	String d_path = prop.getProperty("chromedriver_path");
//			String d_name = prop.getProperty("chromedriver_name");
//			
//			System.setProperty(d_path,d_name); 
//			driver = new ChromeDriver();	
//			Reporter.log("New driver instantiated",true);
//			return driver;
	    	
	    	
	    	String d_path = prop.getProperty("firefoxdriver_path");
			String d_name = prop.getProperty("firefoxdriver_name");
			
			System.setProperty(d_path,d_name);
			driver = new FirefoxDriver();
			Reporter.log("New driver instantiated",true);
			return driver;
		}
		else if(browser.equalsIgnoreCase("SafariBrowser"))
		{
			driver = new SafariDriver();
			return driver;			
		}
		else
		{
			String d_path = prop.getProperty("chromedriver_path");
			String d_name = prop.getProperty("chromedriver_name");
			
			System.setProperty(d_path,d_name); 
			driver = new ChromeDriver();	
			Reporter.log("New driver instantiated",true);
			return driver;
		}
		
		
	//return driver;
		

    	
    	//WebDriver driver = null;
//    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    	//By loginlink = By.linkText("Log In")
//    
//    	System.setProperty("webdriver.chrome.driver","chromedriver"); 
//
//    	driver = new ChromeDriver();
//    	return driver;
}
	public String returnurl()
	{	
		String url = prop.getProperty("url");
		return url;	
		
	}
}
	


