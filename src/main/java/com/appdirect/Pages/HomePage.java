package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class HomePage {
	
	WebDriver driver;
	
	HomePageCheck homechecker = new HomePageCheck(driver);
	
	Utilities utils= new Utilities();
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	public HomePage(WebDriver driver){
		
		 this.driver = driver;
		
	}
	
	public HomePage init1(WebDriver driver) throws FileNotFound1, NoSuchElement1, IOException1, IOException {
		
		prop= readfromfile.getProp();
		String loginclick = prop.getProperty("loginlink_link_Text");
		
		utils.commonCheckTitle(driver);
		
		if(homechecker.homeVerify(driver))
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText(loginclick)).click();
			Reporter.log("Login button clicked",true);
			return new HomePage(driver);
		}
		return null;
	}
	
	public HomePage verifywait() throws NoSuchElement1, FileNotFound1, IOException1, IOException 
	{
		homechecker.waitVisibilityConditionByXpath();
		 Reporter.log("wait is implemented",true);
        return new HomePage(driver);
    }

}
