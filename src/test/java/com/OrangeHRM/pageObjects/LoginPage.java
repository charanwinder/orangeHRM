package com.OrangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//1. i can use this driver anywhere in this project
	public WebDriver driver;// global driver
	
	//2. define constructor why because i am going to create non static methods so to call non static methods in static we need objects
    public LoginPage(WebDriver driver)//local driver
    {
    	this.driver= driver;///driver 2 // to access global/class driver inside constructor use this
    	PageFactory.initElements(driver, this);
    }
    
    // Locators for the element to identify
    
    //3. Locator for username field
    @FindBy(name = "txtUsername")
    WebElement unameTxtField;
    
    //4. Locator for password field
    @FindBy(name = "txtPassword")
    WebElement pwdTxtField;
    
    //5. Locator for login button
    @FindBy(name= "Submit")
    WebElement loginBtn;
    
    //6. Entering Username
    public void setUsername(String username)
    {
    	unameTxtField.clear(); //unameTxtField= driver.findElement(By.id(id))
    	unameTxtField.sendKeys(username);
    	String unameEntered = unameTxtField.getAttribute("value");
    	System.out.println("Value entered in username field is: " + unameEntered);
    	
    }
    
    //7. Entering Password
    public void setPassword(String password)
    {
    	pwdTxtField.clear();
    	pwdTxtField.sendKeys(password);
    	String pwdEntered = pwdTxtField.getAttribute("value");
    	System.out.println("Value entered in password field is: " + pwdEntered);
    }
    
    //8. clicking on login button
    public void clickLoginButton()
    {
    	loginBtn.click();
    	System.out.println("clicked on login button");
    }
    
}
