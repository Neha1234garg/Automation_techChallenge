package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class LoginPage {
	
	WebDriver driver;
	
	LoginPageCheck loginchecker = new LoginPageCheck(driver);
	
	Utilities utils = new Utilities();
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	public LoginPage(WebDriver driver)
	{	
		this.driver=driver;
	}
	public LoginPage init2(WebDriver driver) throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
		prop= readfromfile.getProp();
		String signupclick = prop.getProperty("signuplink_xpath");
		
		utils.commonCheckTitle(driver);
		
		if(loginchecker.loginVerify(driver))
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath(signupclick)).click();
			Reporter.log("Signup button clicked",true);
			return new LoginPage(driver);
		}
		return null;
	}
	
	
	public LoginPage verifywait() throws NoSuchElement1, FileNotFound1, IOException1, IOException
	{	
		loginchecker.waitVisibilityConditionByXpath();
        Reporter.log("wait is implemented",true);
        return new LoginPage(driver);
    }
	
	}
