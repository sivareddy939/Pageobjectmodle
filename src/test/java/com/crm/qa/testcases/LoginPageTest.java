package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.webpages.HomePage;
import com.crm.qa.webpages.LoginPage;

public class LoginPageTest extends TestBase {
	HomePage HomePage;
	LoginPage LoginPage;
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		LoginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest(){
		String title = LoginPage.validateloginpagetitle();
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
	}
	@Test(dependsOnMethods={"loginPageTitleTest"})
	public void crmLogotest(){
		boolean flag = LoginPage.validatecrmlogo();
		Assert.assertTrue(flag, "CRM logo is displayed");
	}
	@Test(dependsOnMethods = { "loginPageTitleTest","crmLogotest"})
	public void logintest(){
		HomePage =LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod()
	public void teardown(){
		driver.quit();
	}
	
	
	
	
	

}
