package com.crm.qa.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//object reporsitory(OR)/webelements
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@value,'Login')]")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[contains(@src,'https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg')]")
	WebElement freecrmlogo;
	
	//this refer the current class objects 
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateloginpagetitle(){
		return driver.getTitle();
	}
	public boolean validatecrmlogo(){
		return freecrmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pswd){
		username.sendKeys(un);
		password.sendKeys(pswd);
		//login btn click
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginbtn);
		
		return new HomePage();
	}
	

}
