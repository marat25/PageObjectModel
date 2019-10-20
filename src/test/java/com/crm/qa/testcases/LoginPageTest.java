package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();  // calls super class constructor 'TestBase'
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); // create object to be able to access all the methods of 'LoginPage' class  
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle(); // accessing method in 'LoginPage'
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small"); 
									// validating the title of the page
	}
	
	@Test(priority=2)
	public void LoginButtonTest() {
		boolean flag = loginPage.validateLoginButton();
		Assert.assertTrue(flag);  // validate the 'flag' condition
	} 	
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// referring to 'homePage' object cause after login it will take us to 'HomePage' class
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
