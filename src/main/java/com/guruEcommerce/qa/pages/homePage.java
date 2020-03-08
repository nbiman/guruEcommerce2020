package com.guruEcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class homePage extends testBase{
	
	mobilePage myMobilePage;
	registrationPage myAccountPage;
	logInPage myLogInPage;
	
	//Page Factory - Object Repository
	
	@FindBy(xpath="//a[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Mobile']")
	static
	WebElement mobileLink;
	
	@FindBy(xpath="//a[text()='TV']")
	static
	WebElement tvLink;
	
	@FindBy(xpath="//span[@class='label' and text()='Account']")
	static
	WebElement accountLink;
	
	@FindBy(xpath="//div[@id='header-account']/div/ul/li/a[text()='My Account']")
	static
	WebElement myAccountLink;
	
	//Initializing page objects
	
	public homePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public static String homePageTitleTest() {
		return driver.getTitle();
	}
	
	public static mobilePage openMobilePage() {
		mobileLink.click();
		return new mobilePage();
		
	}
	
	public static logInPage navigateToLogInPage() {
		accountLink.click();
		myAccountLink.click();
		return new logInPage();
	}
		

}
