package com.project.Reporter;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.appdirect.Pages.*;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;



public class AppTest 
{
	public WebDriver driver;
	
	SelectBrowser browserobj= new SelectBrowser();

	Wait waitobj = new Wait();
	
	Utilities utils = new Utilities();
	
	String url_str;
	
	@BeforeTest
	public void selectBrowser() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
		driver = browserobj.browser1();
		url_str = browserobj.returnurl();
		
		utils.maximizewindow(driver);
		Reporter.log("Maximise browser's window",true);
		
		waitobj.waitClass(driver);
		Reporter.log("Wait applied on the driver for 20 seconds");
		
		Reporter.log("Url is passed",true);
		driver.get(url_str);
		Reporter.log("Web application launched",true);
		
		
	}
	
	@Test
	public void checkValidLogin() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
		HomePage login1 = new HomePage(driver);
		login1.init1(driver);
		Reporter.log("Click action performed on Login Button",true);
		
	}
	
	@Test
	public void checkValidSignup() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
		LoginPage login1 = PageFactory.initElements(driver, LoginPage.class);
		waitobj.waitClass(driver);
		login1.init2(driver);
		Reporter.log("Click action performed on Signup Button",true);
	}
	
	@Test
	public void checkValidUserid() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{
		SignupPage login1 = PageFactory.initElements(driver, SignupPage.class);
		login1.init3(driver);
		Reporter.log("Email is passed to email field",true);
	
	}
	
	@Test (dependsOnMethods = { "checkValidUserid" })
	public void checkValidSignup1() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{
		SignupPage login1 = PageFactory.initElements(driver, SignupPage.class);
		login1.init4(driver);
		Reporter.log("Click action performed on main Signup Button",true);
		
	}
	
	@AfterTest
	public void bieBie()
	{
		Reporter.log("Quiting from browser",true);
		driver.quit();
	}
	
	
}
