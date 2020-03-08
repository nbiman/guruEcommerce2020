package com.guruEcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class registrationPage extends testBase {
	
	homePage myHomepage;
	registrationPage myRegistrationPage;
	accountPage myAccountPage;
	
	
	//Page Object --- Object Repository
	@FindBy(id="firstname")
	static
	WebElement firstNameTextBox;
	
	@FindBy(name="middlename")
	static
	WebElement middleNameTextBox;
	
	@FindBy(id="lastname")
	static WebElement lastNameTextBox;
	
	@FindBy(id="email_address")
	static 
	WebElement emailAddressTextBox;
	
	@FindBy(id="password")
	static 
	WebElement passwordTextBox;
	
	@FindBy(id="confirmation")
	static 
	WebElement confirmationTextBox;
	
	@FindBy(xpath="//button[@title='Register']")
	static WebElement registerBtn;
	
	@FindBy(xpath="//h1[text()='Create an Account']")
	static WebElement pageHeaderText;
	
	
	//Initializing Objects
	public registrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Page Actions
	public accountPage registerNewAccount(String fname, String lname, String email, String pwd, String confPwd) {
		firstNameTextBox.sendKeys(fname);
		lastNameTextBox.sendKeys(lname);
		emailAddressTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pwd);
		confirmationTextBox.sendKeys(confPwd);
		registerBtn.click();
		return new accountPage();
	}
	

}
