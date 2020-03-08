package com.guruEcommerce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guruEcommerce.qa.base1.testBase;
import com.guruEcommerce.qa.pages.homePage;
import com.guruEcommerce.qa.pages.mobilePage;

import junit.framework.Assert;

public class homePageTest extends testBase{
	
	homePage myHomePage;
	mobilePage myMobilePage;
	
	public homePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
	}
	
	@Test
	public void validateHomePageTitle() {
		String title = homePage.homePageTitleTest();
		AssertJUnit.assertEquals(title, "Home page");
	}
	
	/*
	@Test
	public void navigateToLogInPageTest() {
		homePage.navigateToLogInPage();
		String logInPageTitle = driver.getTitle();
		Assert.assertEquals("Customer Login", logInPageTitle);
	}*/
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
