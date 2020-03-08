package com.guruEcommerce.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guruEcommerce.qa.base1.testBase;


public class cartPage extends testBase {
	homePage myHomePage;
	mobilePage myMobilePage;
	
	//Page Object - Object repository
	@FindBy(xpath="//tr/td[2]/h2[@class='product-name']")
	static List<WebElement> productName;
	
	@FindBy(xpath="//input[@title='Qty']")
	static WebElement quantity;
	
	@FindBy(xpath="//button[@class='button btn-update']")
	static WebElement updateBtn;
	
	@FindBy(xpath="//p[@class='item-msg error']")
	static WebElement errorMessage;
	
	@FindBy(xpath="//span[text()='Empty Cart']")
	static WebElement emptyCartLink;
	
	@FindBy(xpath="//span[text()='Continue Shopping']")
	static WebElement continueShoppingLink;
	
	@FindBy(xpath="//h1[text()='Shopping Cart is Empty']")
	static WebElement emptyCartMessage;
	
	//Initializing page objects
	public cartPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String cartPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isVisibleUpdateButton() {
		boolean display = updateBtn.isDisplayed();
		return display;
	}
	
	public void clickUpdateButton() {
		updateBtn.click();
	}
	
	public void editPhoneQuantity(String phoneQuantity) {
		quantity.sendKeys(phoneQuantity);
	}
	
	public String displayErrorMessage() {
		String message = errorMessage.getText();
		return message;
	}
	
	public int cartItems() {
		int cartItemCount = productName.size();
		return cartItemCount;		
	}
	
	public String clickingEmptyCart() {
		emptyCartLink.click();
		String displayMessage = emptyCartMessage.getText();
		return displayMessage;
	}

}
