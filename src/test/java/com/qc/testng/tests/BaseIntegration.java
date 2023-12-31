package com.qc.testng.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qc.testng.utils.TestUtils;

public class BaseIntegration {
	WebDriver driver;
	WebElement email,pass,submit,logout;
	Properties prop;
	String testName;
	TestUtils test = new TestUtils(); 
	@BeforeSuite
	public void setUp() throws IOException { 
	
		prop = test.readProp();
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"),prop.getProperty("chromeVal"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		
		driver.get(prop.getProperty("siteUrl"));
		
	}
	@DataProvider
	public Object[][] loginData() throws IOException {
		return test.readExcelData("logindata");
		
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}

} 
