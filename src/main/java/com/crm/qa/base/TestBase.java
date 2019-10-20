package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.Utility;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	String filePath = "/Users/marat/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties";
	
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(filePath);
			
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/marat/eclipse-workspace/FreeCRMTest/resources/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
	}
	
	

}
