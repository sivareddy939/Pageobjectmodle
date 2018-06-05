package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.Utility;
import com.crm.qa.webpages.ContactsPage;
import com.crm.qa.webpages.HomePage;
import com.crm.qa.webpages.LoginPage;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	Utility util;
	public ContactsPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		util = new Utility();
		contactspage = new ContactsPage();
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		util.switchtoframe();
		contactspage=homepage.clickOnContactsLink();
	}
	@Test(priority=1)
	public void contactslabeltest(){
    boolean	flag =contactspage.verifyContactslabel();
    Assert.assertTrue(flag, "contacts label is missing ");
	}
	@Test(priority=2)
	public void selectContactsCheckBox(){
		contactspage.selectContactsCheckBox("987654 321");
	}
	@DataProvider
	public Object[][] getContactsTestData(){
		Object Data [][]=util.getContactsTestData(prop.getProperty("sheetName"));
	return Data;
	}
	@Test(priority=3,dataProvider="getContactsTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company){
		homepage.clickOnNewContact();
		contactspage.creatNewContact(title, firstname,lastname ,company );
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	

}
