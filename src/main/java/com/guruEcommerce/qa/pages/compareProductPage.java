package com.guruEcommerce.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class compareProductPage extends testBase {
	
	homePage myHomePage;
	mobilePage myMobilePage;
	compareProductPage myCompareProductPage;
	
	//Page Objects --- Object Repository
	
	@FindBy(xpath="//div[@class='page-title title-buttons']/h1")
	static WebElement productCompareHeader;
	
	@FindAll(@FindBy(xpath="//h2[@class='product-name']"))
	static List<WebElement> displayProducts;
	
	@FindBy(xpath="//button[@title='Close Window']")
	static WebElement closeBtn;
	
	
	//Initializing Page Objects
	
	public compareProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	/*
	public static void navigateToProductComparePage() {
		compareBtn.click();
		Set<String> windowHandler=driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		String parentWindow = it.next();
		String comparePage = it.next();
		driver.switchTo().window(comparePage);
		//return new compareProductPage();
	}*/
	
	public static String productComparePageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public static String productComparePageHeader() {
		String pageHeader = productCompareHeader.getText();
		return pageHeader;
	}
	
	public static ArrayList<String> comparePageDisplayProducts() {
		ArrayList<String> displayProductList = new ArrayList<String>();
		int productListLength = displayProducts.size();
		//System.out.println(productListLength);
		for (int i=0; i<productListLength; i++) {
			displayProductList.add(displayProducts.get(i).getText());
		}
		return displayProductList;
	}
	
	public static String closingCompareProductPage() {
		closeBtn.click();
		for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
		String myTitle = driver.getTitle();
		return myTitle;
	}
	

}
