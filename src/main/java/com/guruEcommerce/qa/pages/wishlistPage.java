package com.guruEcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class wishlistPage extends testBase {
	
	
	//Page Object --- Object Repo
	@FindBy(xpath="//button[@class='button btn-share']")
	static WebElement shareWishlistBtn;
	
	@FindBy(xpath="//li[@class='success-msg']")
	static WebElement succesMessage;
	
	
	
	//Initialization
	public wishlistPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions

}
