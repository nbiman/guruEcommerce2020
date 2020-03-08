package com.guruEcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class logInPage extends testBase {
	
	homePage myHomePage;
	logInPage myLogInPage;
	registrationPage myRegistrationPage;
	
	//Page Object --- Object Repo
	@FindBy(xpath="//span[text()='Create an Account']")
	static
	WebElement createAccountBtn;
	
	
	
	//Initialization
	public logInPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public static registrationPage navigateToRegistrationPage() {
		createAccountBtn.click();
		return new registrationPage();
	}
	
	

}
