package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class LoginPageCheck {
	
	WebDriverWait wait;
	
	WebDriver driver;
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	
	LoginPageCheck(WebDriver driver)
	{
		this.driver=driver;
	}
	
public boolean loginVerify(WebDriver driver) throws FileNotFound1, NoSuchElement1, IOException1, IOException 
{
		prop= readfromfile.getProp();
		String signupclick = prop.getProperty("signuplink_xpath");
		if( driver.findElement(By.xpath(signupclick)).isDisplayed()){
			Reporter.log("Signup Element is Visible",true);
			if( driver.findElement(By.xpath(signupclick)).isEnabled()){
				Reporter.log("Signup Element is Visible",true);
				return true;
			}
		}
		return false;
}

public void waitVisibilityConditionByXpath() throws FileNotFound1, NoSuchElement1, IOException1, IOException 
{
	prop= readfromfile.getProp();
	String signupclick = prop.getProperty("signuplink_xpath");
    wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signupclick)));
    Reporter.log("waiting for the signup click",true);
}
}

