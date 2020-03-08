package com.guruEcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guruEcommerce.qa.base1.testBase;

public class accountPage extends testBase {
	
	
	//Pgae Objects -- Page repo
	
	@FindBy(xpath="//li[@class='success-msg']")
	static WebElement succesMessage;
	
	
	
	//Initialization
	public accountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public static String accountCreateSuccessMessage() {
		String displayMessage = succesMessage.getText();
		return displayMessage;	
	}
	
	

}
