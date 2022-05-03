package com.OrangeHRM.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	//1.
	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//2. 
	@BeforeClass
	@Parameters("browser")
	public void setup(String browserName) throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resources\\config.properties");// use relative path concept BUt if we copy from begining then its is called absolute path
		prop.load(fis);
		
		if (browserName.equalsIgnoreCase("chrome")) 
        {
        	WebDriverManager.chromedriver().setup(); 
            driver = new ChromeDriver();
            logger.info("Chrome Browser is launched successfully");
		} else if(browserName.equalsIgnoreCase("edge")) 
        {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	        logger.info("Edge Browser is launched successfully");
		} else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        logger.info("Firefox Browser is launched successfully");	
		}else
		{
			logger.info("Please pass the coreect Browser name currently we are supporting chrome,edge and firefox only");
		}
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		
		//System.out.println("Chrome browser is launched successfully");
		logger.info("Chrome browser is launched successfully");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		//System.out.println("OrangeHRM Application is launched successfully");
		logger.info("OrangeHRM Application is launched successfully");
	}
	
	
	//4.
	@AfterClass
	public void teardown()
	{
		driver.quit();
		//System.out.println("Browser closed successfully");
		logger.info("Browser closed successfully");
	}
    
	public void capturescreen(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\ " + testName + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshots captures successfully");
	}
}
