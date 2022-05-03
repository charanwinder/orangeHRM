package com.OrangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage 
{
	//1	
	public WebDriver driver;
	
	//2    
	public DashboardPage(WebDriver driver) 
	    {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
	
	//3 Locator for dashboard link
	@FindBy(linkText = "Dashboard")
	WebElement dashboardLnk;
	
	//4
	public boolean dashboardLinkDisplayed()
	{
		boolean status = dashboardLnk.isDisplayed();
		return status;
	}
	

}
