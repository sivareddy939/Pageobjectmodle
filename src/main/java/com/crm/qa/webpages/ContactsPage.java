package com.crm.qa.webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	@FindBy(xpath ="//select[@name='title']/option")
	WebElement selectTitle;
	@FindBy(name="title")
	WebElement selecttitle;
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id ="surname")
	WebElement lastName;
	/*@FindBy(xpath="//a[text()='987654 321']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	*/
	@FindBy(name ="client_lookup")
	WebElement Company;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactslabel(){
		return contactslabel.isDisplayed();
	}
	public void selectContactsCheckBox(String name){
		 driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void creatNewContact(String title,String firstname,String lastname,String company){
/*		Select select = new Select(selectTitle);
		List<WebElement> listOfTitleoptions = select.getOptions();
		for(WebElement titles : listOfTitleoptions){
			String listTitles = titles.getText();
			if(listTitles.equalsIgnoreCase(title)){
				titles.click();
			}
		}*/
		Select select = new Select(selecttitle);
		select.selectByVisibleText(title);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		Company.sendKeys(company);
		saveBtn.click();
	}

}
