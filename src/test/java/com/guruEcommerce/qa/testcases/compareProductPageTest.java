package com.guruEcommerce.qa.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.guruEcommerce.qa.base1.testBase;
import com.guruEcommerce.qa.pages.compareProductPage;
import com.guruEcommerce.qa.pages.homePage;
import com.guruEcommerce.qa.pages.mobilePage;

public class compareProductPageTest extends testBase {
	
	homePage myHomePage;
	mobilePage myMobilePage;
	compareProductPage myCompareProductPage;
	
	public compareProductPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
		myMobilePage = homePage.openMobilePage();
		String myCompProduct1 = "SONY XPERIA";
		String myCompProduct2 = "IPHONE";
		ArrayList<String> compProducts = new ArrayList<String>();
		compProducts.add(myCompProduct1);
		compProducts.add(myCompProduct2);
		mobilePage.addComparingProducts(compProducts);
		myCompareProductPage = mobilePage.navigateToProductComparePage(); //driver controller to switch to compareProduct page is given in mobilePage.navigateToProductComparePage() 	
	}
	
	@Test
	public void comparingProductsPageTitleTest() {
		String title = compareProductPage.productComparePageTitle();
		Assert.assertEquals(title, "Products Comparison List - Magento Commerce");
	}
	
	@Test
	public void productComparePageHeaderTest() {
		String pageHeader = compareProductPage.productComparePageHeader();
		AssertJUnit.assertEquals(pageHeader, "COMPARE PRODUCTS");
	}
	
	@Test
	public void verifyingDisplayedProducts() {
		String myCompProduct1 = "SONY XPERIA";
		String myCompProduct2 = "IPHONE";
		ArrayList<String> compProducts = new ArrayList<String>();
		compProducts.add(myCompProduct1);
		compProducts.add(myCompProduct2);
		mobilePage.addComparingProducts(compProducts);
		ArrayList<String> displayedProducts = compareProductPage.comparePageDisplayProducts();
		AssertJUnit.assertEquals(compProducts, displayedProducts);
	}
	
	@Test
	public void closingCompareProductPageTest() {
		compareProductPage.closingCompareProductPage();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
