package com.project.Reporter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	WebElement element1;
    	
    	WebDriver driver;
    	
    	//By loginlink = By.linkText("Log In")
    
    	System.setProperty("webdriver.chrome.driver","chromedriver"); 

    	driver = new ChromeDriver();	
    	
    	driver.manage().window().maximize();
    	
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.get("http://www.appdirect.com");
    	
    	Actions a = new Actions(driver);
    	
    	driver.findElement(By.linkText("Log In")).click();
    	
		System.out.println("Link Test Pass1");
		
		driver.findElement(By.xpath("//*[@id='id5']/fieldset/div[3]/menu/a")).click();
	
		System.out.println("Link Test Pass2");
		
	
    	
    }
}
