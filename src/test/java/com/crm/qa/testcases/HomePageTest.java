package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.Utility;
import com.crm.qa.webpages.ContactsPage;
import com.crm.qa.webpages.HomePage;
import com.crm.qa.webpages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	Utility testutil;
	ContactsPage contactspage;
	public HomePageTest(){
		super();
	}
	
	Logger log = Logger.getLogger(HomePage.class);

	@BeforeMethod
	public void setup(){
		initialization();
		loginpage = new LoginPage();
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    testutil = new Utility();
	    contactspage = new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle(){
		log.info("****************************** starting test case *****************************************");
		log.info("******************************VerifyHomePageTitle *****************************************");
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Homepage title is not matched");
	}
	@Test(priority=2)
	public void verifyUserName(){
		testutil.switchtoframe();
		Assert.assertTrue(homepage.verifycorrectUserName(), "username is not matching");
		}
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testutil.switchtoframe();
		contactspage = homepage.clickOnContactsLink();
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
