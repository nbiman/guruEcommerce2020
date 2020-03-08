package com.guruEcommerce.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class xperiaDetailPage extends testBase{
	
	homePage myHomePage;
	mobilePage myMobilePage;
	//static xperiaDetailPage myXperiaDetailPage;
	
	// Page Object - Object Repository
	@FindBy(xpath="//span[@class='h1']")
	static WebElement productName;
	
	@FindBy(xpath="//span[@class='price']")
	static WebElement displayPrice;
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	static WebElement cartButton;
	
	// Initializing Page Objects
	public xperiaDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public static String xperiaDetailPageTitleTest() {
		return driver.getTitle();
	}
	
	public static String xperiaProductName() {
		//String myProduct = productName.getText();
		String product = productName.getText();
		System.out.println(product);
		return product;
	}
	
	public static String showPrice() {
		String price=displayPrice.getText();
		//cartButton.click();
		
		return price;
	}

}
