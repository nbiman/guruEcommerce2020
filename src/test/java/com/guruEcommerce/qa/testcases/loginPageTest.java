package com.guruEcommerce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guruEcommerce.qa.base1.testBase;
import com.guruEcommerce.qa.pages.homePage;
import com.guruEcommerce.qa.pages.logInPage;

import junit.framework.Assert;

public class loginPageTest extends testBase {
	homePage myHomePage;
	logInPage myLogInPage;
	
	
	public loginPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
		myLogInPage = myHomePage.navigateToLogInPage();
		
	}
	
	@Test
	public void logInPageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals("Customer Login", title);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
