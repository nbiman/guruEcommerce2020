package com.guruEcommerce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guruEcommerce.qa.base1.testBase;
import com.guruEcommerce.qa.pages.accountPage;
import com.guruEcommerce.qa.pages.homePage;
import com.guruEcommerce.qa.pages.logInPage;
import com.guruEcommerce.qa.pages.registrationPage;
import com.guruEcommerce.qa.util.testUtil;

public class registrationPageTest extends testBase {
	homePage myHomePage;
	logInPage myLogInPage;
	registrationPage myRegistrationPage;
	accountPage myAccountPage;
	
	public registrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
		myLogInPage = myHomePage.navigateToLogInPage();
		myRegistrationPage = myLogInPage.navigateToRegistrationPage();
	}
	
	
	
	@Test
	public void registrationPageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Create New Customer Account");
	}
	
	
	
	
	@Test(dataProvider="readTestData")
	public void createNewAccountTest(String firstname, String lastname, String email, String password, String confirmation) {
		//myAccountPage = myRegistrationPage.createNewAccount("First", "Last", "test@test.com", "Password", "Password");
		myRegistrationPage.registerNewAccount(firstname, lastname, email, password, confirmation);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] readTestData() {
		Object[][] fetchedData = testUtil.getTestData("Registration");
		//System.out.println(fetchedData[1][2]);
		return fetchedData;
	}

}
