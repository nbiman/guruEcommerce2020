package com.guruEcommerce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guruEcommerce.qa.base1.testBase;
import com.guruEcommerce.qa.pages.homePage;
import com.guruEcommerce.qa.pages.mobilePage;
import com.guruEcommerce.qa.pages.xperiaDetailPage;



public class mobilePageTest extends testBase {
	homePage myHomePage;
	static mobilePage myMobilePage;
	xperiaDetailPage myXperiaDetailPage;
	
	public mobilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
		myMobilePage = homePage.openMobilePage();
	}
	
	@Test
	public void validateMobilePageTitleTest() {
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "Mobile");
	}
	
	@Test
	public void validateSortItems() {
		ArrayList<String> initProductList = mobilePage.initItems();
		//System.out.println(initProductList);
		String shortCriteria = "Name";
		ArrayList<String> sortedProductList = myMobilePage.sortItems(shortCriteria);
		//System.out.println(sortedProductList);
		Collections.sort(initProductList);
		AssertJUnit.assertEquals(sortedProductList, initProductList);
	}
	
	@Test
	public static void validateCostReading() {
		String product = "SONY XPERIA";
		String productPrice = myMobilePage.costReading(product);
		System.out.println(productPrice);
		//return product.toString();		
		
	}
	/*
	@Test(priority=4)
	public void validateNavigateXperiaDetailPage() {
		xperiaDetailPage myXperiaDetailPage = mobilePage.navigateXperiaDetailPage("SONY XPERIA");
	}*/
	
	
	
	@Test
	public void compareButtonDisplayTest() {
		boolean myState = mobilePage.isVisisbleCompareButton();
		System.out.println(myState);
		AssertJUnit.assertEquals(myState, false);
	}
	/*
	@Test
	public void comparingProductsPageTitleTest() {
		String myCompProduct1 = "SONY XPERIA";
		String myCompProduct2 = "IPHONE";
		ArrayList<String> compProducts = new ArrayList<String>();
		compProducts.add(myCompProduct1);
		compProducts.add(myCompProduct2);
		mobilePage.addComparingProducts(compProducts);
		mobilePage.navigateToProductComparePage();
		String title = mobilePage.productComparePageTitle();
		AssertJUnit.assertEquals(title, "Products Comparison List - Magento Commerce");
	}
	
	@Test
	public void productComparePageHeaderTest() {
		String myCompProduct1 = "SONY XPERIA";
		String myCompProduct2 = "IPHONE";
		ArrayList<String> compProducts = new ArrayList<String>();
		compProducts.add(myCompProduct1);
		compProducts.add(myCompProduct2);
		mobilePage.addComparingProducts(compProducts);
		mobilePage.navigateToProductComparePage();
		String pageHeader = mobilePage.productComparePageHeader();
		AssertJUnit.assertEquals(pageHeader, "COMPARE PRODUCTS");
		//ArrayList<String> displayedProducts = mobilePage.comparePageDisplayProducts();
		//Assert.assertEquals(compProducts, displayedProducts);	
	}
	
	@Test
	public void verifyingDisplayedProducts() {
		String myCompProduct1 = "SONY XPERIA";
		String myCompProduct2 = "IPHONE";
		ArrayList<String> compProducts = new ArrayList<String>();
		compProducts.add(myCompProduct1);
		compProducts.add(myCompProduct2);
		mobilePage.addComparingProducts(compProducts);
		mobilePage.navigateToProductComparePage();
		ArrayList<String> displayedProducts = mobilePage.comparePageDisplayProducts();
		AssertJUnit.assertEquals(compProducts, displayedProducts);
	}
	
	@Test
	public void closingCompareProductPageTest() {
		String myCompProduct1 = "SONY XPERIA";
		String myCompProduct2 = "IPHONE";
		ArrayList<String> compProducts = new ArrayList<String>();
		compProducts.add(myCompProduct1);
		compProducts.add(myCompProduct2);
		mobilePage.addComparingProducts(compProducts);
		mobilePage.navigateToProductComparePage();
		mobilePage.closingCompareProductPage();
	}*/
	
	
	////*****************************************************
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
