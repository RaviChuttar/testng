package com.qc.testng.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseIntegration{
	@BeforeMethod
	public void locateElement() {
		email = driver.findElement(By.id("email"));
		email.clear();
		pass = driver.findElement(By.id("password"));
		pass.clear();
		submit = driver.findElement(By.id("submit"));
	}
	  @Test(dataProvider  = "loginData")
	  public void doLogin(String tName, String uName, String uPassword) {
		  testName = tName;
		  email.sendKeys(uName);
		  pass.sendKeys(uPassword); 
		  submit.click();
	  }
	  @AfterMethod
	  public void doAssert() throws InterruptedException {
		  String actResult = driver.getTitle();
		  if(testName.equals("Both are valid")) {
		Assert.assertEquals(actResult,"Queue Codes | Dashboard");
		logout = driver.findElement(By.id("hlogout"));
		logout.click();
		  }
		  else {
		  Assert.assertEquals(actResult,"Queue Codes | Log in"); 
		  }
		  Thread.sleep(2000);
	  }
	

}
