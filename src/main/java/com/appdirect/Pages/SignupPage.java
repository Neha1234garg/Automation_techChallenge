package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class SignupPage {
	
	WebDriver driver;
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	Utilities utils= new Utilities();
	
	SignupPageCheck signupchecker = new SignupPageCheck(driver);
	
	
	String user_url=(RandomStringUtils.randomAlphabetic(6)+RandomStringUtils.randomAlphanumeric(3, 6)+"@yopmail.com");
	
	public SignupPage(WebDriver driver)
		{
			this.driver=driver;
		}

public LoginPage init3(WebDriver driver) throws IOException, FileNotFound1, NoSuchElement1, IOException1
{
		prop= readfromfile.getProp();
		String signupurlkmain = prop.getProperty("signupurl_xpath");
		Assert.assertEquals("Sign Up for AppDirect", driver.getTitle(), "Strings are not matching");
		if(signupchecker.signupVerifyurl(driver))
		{	
			driver.findElement(By.xpath(signupurlkmain)).sendKeys(user_url);
			Reporter.log("values passed in user url link",true);
			return new LoginPage(driver);
		}
		return null;
	}
public LoginPage init4(WebDriver driver) throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
	prop= readfromfile.getProp();
	String signupclickmain = prop.getProperty("signupclk_xpath");
	Assert.assertEquals("Sign Up for AppDirect", driver.getTitle(), "Strings are not matching");
	if(signupchecker.signupVerifyclk(driver))
	{
		driver.findElement(By.xpath(signupclickmain)).click();
		Reporter.log("main login button clicked",true);
		return new LoginPage(driver);
	}
	return null;
}

	
	public SignupPage verifywait() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
		Reporter.log("wait is implemented");        
		signupchecker.waitVisibilityConditionByXpath();
        return new SignupPage(driver);
    }

}
