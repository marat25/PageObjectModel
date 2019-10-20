package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// Page Factory - Object repository:
	
	@FindBy(name="email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement loginButton1;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginButton2;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath = "//image[contains(@src,'/images/cogtiny1.jpg')]")
	WebElement logoImage;
	
	// Initializing Page Objects:
	
	public LoginPage() { 
		PageFactory.initElements(driver, this);
	}
	
	// Methods/Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginButton() {
		return loginButton1.isDisplayed();
	}
	
	public boolean validateLogoImage() {
		return logoImage.isDisplayed();
	}
	
	public HomePage login(String userN, String pwd) {
		loginButton1.click();
		username.sendKeys(userN);
		password.sendKeys(pwd);
		loginButton2.click();
		
		return new HomePage();
	}
}
