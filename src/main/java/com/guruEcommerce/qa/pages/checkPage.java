package com.guruEcommerce.qa.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import junit.framework.Assert;
import org.testng.Assert;

public class checkPage {
	public static int count=0;
	public static String testDataSheetPath = "/Users/bimanb/Documents/2020/learning/guruEcommerce/src/main/java/com/guruEcommerce/qa/testdata/guru99_testdata.xlsx";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/bimanb/Documents/2020/learning/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		
		List<WebElement> products = driver.findElements(By.xpath("//li[@class='item last']"));
		List<WebElement> productName = driver.findElements(By.xpath("//h2[@class='product-name']"));
		count = products.size();
		List<WebElement> productImage = driver.findElements(By.xpath("//a[@class='product-image']"));
		List<WebElement> productPrice = driver.findElements(By.xpath("//span[@class='price']"));
		List<WebElement> compareProductLink = driver.findElements(By.xpath("//a[@class='link-compare']"));
		
		String item1 = addingElement(driver, "SONY XPERIA");
		String item2 = addingElement(driver, "IPHONE");
		
		System.out.println(item1);
		System.out.println(item2);
	
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		
		Set<String> windowHandler=driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		String parentPage= it.next();
		String comparePage = it.next();
		
		driver.switchTo().window(comparePage);
		String title = driver.getTitle();
		System.out.println(title);
		
		List<WebElement> displayProducts = driver.findElements(By.xpath("//h2[@class='product-name']"));
		int displayProductLength = displayProducts.size();
		ArrayList<String > comparePageProducts = new ArrayList<String>();
		for (int i=0; i<displayProductLength; i++) {
			comparePageProducts.add(displayProducts.get(i).getText());
			//String myProduct = displayProducts.get(i).getText();
			
		}
		System.out.println(comparePageProducts);
		//System.out.println(driver.findElement(By.xpath("//h1[text()='Compare Products']")).getText());
		ArrayList<String> selectedProducts = new ArrayList<String>();
		selectedProducts.add(item1);
		selectedProducts.add(item2);
		System.out.println(selectedProducts);
		
		try {
			assertEquals(selectedProducts, comparePageProducts);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		for (int i=0; i<count; i++) {
			String myProdName = productName.get(i).getText();
			if (myProdName.equalsIgnoreCase("Sony Xperia")){
				compareProductLink.get(i).click();
				break;
			}
		}
		
		for (int i=0; i<count; i++) {
			System.out.println("I'm here");
			String myProdName = productName.get(i).getText();
			if (myProdName.equalsIgnoreCase("IPHONE")){
				compareProductLink.get(i).click();
				break;
			} 
		}*/
				
		/*for (int i=0; i<count; i++) {
			String myProdName = productName.get(i).getText();
			//String prodPrice = 
			System.out.println(myProdName);
			if (myProdName.equalsIgnoreCase("IPHONE")) {
				String myProdPrice = productPrice.get(i).getText();
				System.out.println(myProdPrice);
				break;
			}
			
			
			//if (prodName.contains("SAMSUNG GALAXY")) {
			//	productImage.get(i).click();
			//	break;
			//}
		}*/

	}
	
	public static String addingElement(WebDriver driver, String item) {
		List<WebElement> productName = driver.findElements(By.xpath("//h2[@class='product-name']"));
		List<WebElement> compareProductLink = driver.findElements(By.xpath("//a[@class='link-compare']"));
		int count = productName.size();
		for (int i=0; i<count; i++) {
			String myProdName = productName.get(i).getText();
			if (myProdName.equalsIgnoreCase(item)){
				compareProductLink.get(i).click();
				break;
			}
		}
		return item;
	}
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(testDataSheetPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook book = null;		
		try {
			book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0; i<sheet.getLastRowNum(); i++) {
			for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	

}
