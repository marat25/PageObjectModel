package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath = "//td[contains(text(),'Akish Kadyr')]")
	WebElement checkbox;

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactButton;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//input[@name = 'value' and @autocomplete = 'new-password']")
	WebElement email;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'Akish Kadyr')]"));
	}

	public void createNewContact(String firstN, String lastN, String eMail) {
		newContactButton.click();

		firstName.sendKeys(firstN);
		lastName.sendKeys(lastN);
		email.sendKeys(eMail);

		saveButton.click();

	}
}
