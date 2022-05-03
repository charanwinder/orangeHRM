package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.testBase.BaseClass;

public class TC002_CheckApplicationTitile extends BaseClass
{
	@Test
	public void checkAppTitle() throws IOException
	{
		String appTitle = driver.getTitle();
		Assert.assertEquals(appTitle, "OrangeHRM", "Title not found");
		//System.out.println("Title of application is OrangeHRM");
		logger.info("Title of application is OrangeHRM");
		
		capturescreen(driver, "TC002_CheckApplicationTitile");
	}
}
