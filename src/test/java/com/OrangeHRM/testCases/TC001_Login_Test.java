package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.DashboardPage;
import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC001_Login_Test extends BaseClass
{
		@Test
		public void loginTest() throws IOException 
		{
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(prop.getProperty("username"));
			logger.info("Usernam enterd is: " + prop.getProperty("username"));
			lp.setPassword(prop.getProperty("password"));
			logger.info("PAssword enterd is: " + prop.getProperty("password"));
			lp.clickLoginButton();
			logger.info("Clicked on Login Button");
			
			DashboardPage dp = new DashboardPage(driver);
			boolean actVal = dp.dashboardLinkDisplayed();
			///checking
			Assert.assertEquals(actVal, true, "user login failed");
			//System.out.println("User login successfully");
			logger.info("User login successfully");
			
			capturescreen(driver, "TC001_Login_Test");
		}		
}
