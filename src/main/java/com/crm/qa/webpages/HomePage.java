package com.crm.qa.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td/font[contains(text(),'User: Naveen K')]")
	WebElement usernamelable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	//New contacts link
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContactslink;
	//Deals
	@FindBy(xpath ="//a[contains(text(),'Deals')]")
	WebElement Dealslink;
	//Tasks
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Taskslink;
	
	//initializing the Homepage objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public boolean verifycorrectUserName(){
		return usernamelable.isDisplayed();
	}
	public ContactsPage clickOnContactsLink(){
		contactslink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink(){
		Dealslink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContact(){
		
		Actions Act = new Actions(driver);
		Act.moveToElement(contactslink).build().perform();
		NewContactslink.click();
		
	}
	
	
	
	
	

}
