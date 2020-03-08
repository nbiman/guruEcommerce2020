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
import com.guruEcommerce.qa.pages.xperiaDetailPage;

public class xperiaDetailPageTest extends testBase{
	homePage myHomePage;
	mobilePage myMobilePage;
	xperiaDetailPage myXperiaDetailPage;
	mobilePageTest myMobileTestPage;
	
	public xperiaDetailPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
		myMobilePage = homePage.openMobilePage();
		myXperiaDetailPage = mobilePage.navigateXperiaDetailPage("SONY XPERIA");
		
	}
	
	@Test
	public void validateXperiaDetailPageTitleTest() {
		//myMobilePage.
		String title = xperiaDetailPage.xperiaDetailPageTitleTest();
		AssertJUnit.assertEquals("Sony Xperia - Mobile", title);
	}
	@Test
	public void validateXperiaProductName() {
		String product = xperiaDetailPage.xperiaProductName();
		AssertJUnit.assertEquals("SONY XPERIA", product);
	}
	
	@Test
	public void validateShowPrice() {
		//xperiaDetailPage.showPrice();
		String price = xperiaDetailPage.showPrice();
		AssertJUnit.assertEquals("$100.00", price);
	}
	/*
	@Test(priority=4)
	public void compareXperiaPrice() {
		String productPagePrice = myMobileTestPage.validateCostReading();
		String xperiaDetailPagePrice = myXperiaDetailPage.showPrice();
		Assert.assertEquals(productPagePrice, xperiaDetailPagePrice);
	}
	*/
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
