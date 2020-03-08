package com.guruEcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class sharingWishListPage extends testBase {
	
	
	
	//Page Object --- Object Repo
	@FindBy(xpath="//textarea[@id='email_address']")
	static WebElement emailAddressTextField;
	
	@FindBy(xpath="//textarea[@id='message']")
	static WebElement messageTextField;
	
	@FindBy(xpath="//button[@title='Share Wishlist']")
	static WebElement shareWishListBtn;
	
	// Initialization
	public sharingWishListPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions --

}
