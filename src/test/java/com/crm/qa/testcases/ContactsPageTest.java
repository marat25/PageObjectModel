package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Utility;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing");
	}

	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("Akish Kadyr");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("Akish Kadyr");
		contactsPage.selectContactsByName("Marat T");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = Utility.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String email) {
		// contactsPage.createNewContact("Ruslan", "Ibragim", "ruslan@mail.ru");
		contactsPage.createNewContact(firstName, lastName, email);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
