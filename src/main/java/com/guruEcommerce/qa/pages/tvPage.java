package com.guruEcommerce.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class tvPage extends testBase {
	
	
	//Page Object -- Page Repo
	@FindAll(@FindBy(xpath="//li[@class='item last']"))
	static List<WebElement> products;
	
	@FindAll(@FindBy(xpath="//a[@class='link-wishlist']"))
	static List<WebElement> wishListLink;
	
	
	//Initialization
	public tvPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions

}
