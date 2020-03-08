package com.guruEcommerce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guruEcommerce.qa.base1.testBase;
import com.guruEcommerce.qa.pages.accountPage;
import com.guruEcommerce.qa.pages.homePage;
import com.guruEcommerce.qa.pages.logInPage;
import com.guruEcommerce.qa.pages.registrationPage;
import com.guruEcommerce.qa.util.testUtil;

public class accountPageTest extends testBase{
	homePage myHomePage;
	logInPage myLogInPage;
	registrationPage myRegistrationPage;
	accountPage myAccountPage;
	
	public accountPageTest() {
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		myHomePage = new homePage();
		myLogInPage = homePage.navigateToLogInPage();
		myRegistrationPage = logInPage.navigateToRegistrationPage();
		//myRegistrationPage.registerNewAccount(firstname, lastname, email, password, confirmation)
	}
	
	
	@Test(dataProvider="readTestData")
	public void accountCreationSuccessMessageTest(String firstname, String lastname, String email, String password, String confirmation) {
		myAccountPage = myRegistrationPage.registerNewAccount(firstname, lastname, email, password, confirmation);
		String displayedMessage = accountPage.accountCreateSuccessMessage();
		Assert.assertEquals(displayedMessage, "Thank you for registering with Main Website Store.");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] readTestData() {
		Object[][] fetchedData = testUtil.getTestData("Sheet1");
		//System.out.println(fetchedData[1][2]);
		return fetchedData;
	}

}
