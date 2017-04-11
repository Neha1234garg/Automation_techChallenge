package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Verify;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class SignupPageCheck 
{
	WebDriverWait wait;
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	WebDriver driver;
	
	SignupPageCheck(WebDriver driver)
	{
		this.driver=driver;
	}
	
public boolean signupVerifyurl(WebDriver driver) throws FileNotFound1, NoSuchElement1, IOException1, IOException 
{
	prop= readfromfile.getProp();
	String signupurlkmain = prop.getProperty("signupurl_xpath");
		if( driver.findElement(By.xpath(signupurlkmain)).isDisplayed())
		{
			Reporter.log("Main url is Visible",true);
			return true;
		}
		return false;
	}

	public boolean signupVerifyclk(WebDriver driver) throws FileNotFound1, NoSuchElement1, IOException1, IOException 
	{
		prop= readfromfile.getProp();
		String signupclickmain = prop.getProperty("signupclk_xpath");
		if( driver.findElement(By.xpath(signupclickmain)).isDisplayed())
	{
		Reporter.log("Main Signup Element is Visible",true);
		if( driver.findElement(By.xpath(signupclickmain)).isEnabled())
		{
			Reporter.log("Main Signup Element is Enable",true);
			return true;
		}
	}
	return false;
	}
	
	
	public void CheckTitleSignup(WebDriver driver) 
	{
		Assert.assertEquals("Sign Up for AppDirect", driver.getTitle(), "Strings are not matching");
	}
	
	public void waitVisibilityConditionByXpath() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{
		prop= readfromfile.getProp();
		String signupclickmain = prop.getProperty("signupclk_xpath");
	    wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signupclickmain)));
	    Reporter.log("waiting for the main signup click",true);
	}
}

