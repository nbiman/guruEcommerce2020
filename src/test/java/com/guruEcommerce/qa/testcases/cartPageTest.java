package com.guruEcommerce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guruEcommerce.qa.base1.testBase;
import com.guruEcommerce.qa.pages.cartPage;
import com.guruEcommerce.qa.pages.homePage;
import com.guruEcommerce.qa.pages.mobilePage;

public class cartPageTest extends testBase{
	homePage myHomePage;
	mobilePage myMobilePage;
	cartPage myCartPage;
	
	public cartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
		myMobilePage = homePage.openMobilePage();
		myCartPage = mobilePage.navigateToCartPage("SONY XPERIA");
	}
	
	@Test
	public void cartPageTitleTest() {
		String title = myCartPage.cartPageTitle();
		AssertJUnit.assertEquals("Shopping Cart", title);
	}
	
	@Test
	public void isVisisbleUpdateButtonTest() {
		boolean value = myCartPage.isVisibleUpdateButton();
		AssertJUnit.assertFalse(value);
	}
	
	@Test
	public void updateButtonVisibilityPostQuantityChange() {
		myCartPage.editPhoneQuantity("3");
		boolean value = myCartPage.isVisibleUpdateButton();
		AssertJUnit.assertTrue(value);
	}
	
	@Test
	public void verifyDisplayErrorMessage() {
		myCartPage.editPhoneQuantity("1000");
		myCartPage.clickUpdateButton();
		String returnedErrorMessage = myCartPage.displayErrorMessage();
		String expectederrorMessage = "The requested quantity for Sony Xperia is not available";
		AssertJUnit.assertEquals(returnedErrorMessage, expectederrorMessage);
	}
	
	@Test
	public void clickingEmptyCartTest() {
		myCartPage.editPhoneQuantity("1000");
		myCartPage.clickUpdateButton();
		String returnedMessage = myCartPage.clickingEmptyCart();
		AssertJUnit.assertEquals("SHOPPING CART IS EMPTY", returnedMessage);		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
