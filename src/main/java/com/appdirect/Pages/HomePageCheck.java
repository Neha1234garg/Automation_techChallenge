package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class HomePageCheck {
	
	WebDriverWait wait;
	WebDriver driver;
	Properties prop = new Properties();
	ReadDBfile readfromfile= new ReadDBfile();
	
	HomePageCheck(WebDriver driver){
		this.driver=driver;
	}
	
public boolean homeVerify(WebDriver driver) throws FileNotFound1, NoSuchElement1, IOException1, IOException {
		
		prop= readfromfile.getProp();
	
		String loginclick = prop.getProperty("loginlink_link_Text");
		
		if( driver.findElement(By.linkText(loginclick)).isDisplayed())
		{
			Reporter.log("Login Element is Visible",true);
			if( driver.findElement(By.linkText(loginclick)).isEnabled())
			{
				Reporter.log("Login Element is Enable",true);
				return true;
			}
		}
		return false;
}	

public void waitVisibilityConditionByXpath() throws FileNotFound1, NoSuchElement1, IOException1, IOException 
{
	prop= readfromfile.getProp();
	String loginclick = prop.getProperty("loginlink_link_Text");

    wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginclick)));
   Reporter.log("waiting for the login click",true);
}
}

