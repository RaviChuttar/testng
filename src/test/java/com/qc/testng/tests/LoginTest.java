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
		pass = driver.findElement(By.id("password"));
		submit = driver.findElement(By.id("submit"));
	}
	  @Test
	  public void doLogin() {
		  email.sendKeys("queuecodes@gmail.com");
		  pass.sendKeys("123456"); 
		  submit.click();
	  }
	  @AfterMethod
	  public void doAssert() {
		  String actResult = driver.getTitle();
		  Assert.assertEquals(actResult,"Queue Codes | Dashboard"); 
	  }
	

}
