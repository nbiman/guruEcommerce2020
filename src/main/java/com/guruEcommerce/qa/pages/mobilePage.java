package com.guruEcommerce.qa.pages;

//import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guruEcommerce.qa.base1.testBase;

public class mobilePage extends testBase {
	
	//static mobilePage myMobilePage;
	homePage myHomePage;
	tvPage myTVPage;
	cartPage myCartPage;
	//compareProductPage myCompareProductPage;
	static xperiaDetailPage myXperiaDetailPage;
	
	static ArrayList<String> initialProductList;
	static ArrayList<String> changedProductList;
	static ArrayList<String> productList;
	static ArrayList<String> listItems;
	
	//Page Object - Object Repository
	
	@FindBy(xpath="//h1[text()='Mobile']")
	static WebElement categoryTitle;
	
	@FindBy(xpath="//select[@title='Sort By']")
	static WebElement sortItem;
	
	@FindAll({@FindBy(xpath="//li[@class='item last']")})
	static List<WebElement> products;
	
	@FindAll({@FindBy(xpath="//a[@class='product-image']")})
	static List<WebElement> productImage;
	
	@FindAll({@FindBy(xpath="//h2[@class='product-name']")})
	static List<WebElement> productName;
	
	@FindAll(@FindBy(xpath="//span[@class='price']"))
	static List<WebElement> productPrice;
	
	@FindAll(@FindBy(xpath="//a[@class='link-compare']"))
	static List<WebElement> addCompareLink;
	
	@FindBy(xpath="//button[@title='Compare']")
	static WebElement compareBtn;
	
	//@FindBy(xpath="//div[@class='price-box']")
	//static WebElement productPrice;
	
	@FindBy(xpath="//a[@class='product-image']")
	static WebElement choosenProduct;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	static WebElement addToCartBtn;
	////li[@class='item last']
	
	//@FindAll({@FindBy(xpath="//li[@class='item last']/div/h2")})
	//static List<WebElement> productList;
	
	// Page Object for the Compare product Pop up
	//page title = "Products Comparison List - Magento Commerce"
	
	@FindBy(xpath="//div[@class='page-title title-buttons']/h1")
	static WebElement productCompareHeader;
	
	@FindAll(@FindBy(xpath="//h2[@class='product-name']"))
	static List<WebElement> displayProducts;
	
	@FindBy(xpath="//button[@title='Close Window']")
	static WebElement closeBtn;
	
	
	
	//Initializing page objects
	
	public mobilePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public static String mobilePageTitleTest() {
		return driver.getTitle();
	}
	
	public static ArrayList<String> initItems(){
		//String[] initialProductList;
		initialProductList = new ArrayList<String>();//declaring array-list to store all products
		int productLength = products.size(); //length of products
		for (int i=0; i<productLength; i++) {	//storing all products to the array-list
			//initialProductList = add(productName.get(i).getText());
			initialProductList.add(productName.get(i).getText());
		}
		
		return (initialProductList);		
	}
	
	public ArrayList<String> sortItems(String option) {
		Select s = new Select(sortItem); 
		s.selectByVisibleText(option);
		changedProductList = initItems(); 
		/*changedProductList = new ArrayList<String>();
		int changedProductLength = productName.size();
		for (int i=0; i<changedProductLength; i++) {
			changedProductList.add(productName.get(i).getText());
		}*/
		return (changedProductList);
	}
	
	public String costReading(String product) {
		String price = null;
		productList = initItems();		
		int productLength = productList.size();
		for (int i=0; i<productLength; i++) {
			String productName = productList.get(i);		
			if (productName.equalsIgnoreCase(product)) {
				price=productPrice.get(i).getText();
				break;
			}
		}
		return price;
	}
	
	public static xperiaDetailPage navigateXperiaDetailPage(String product) {
		listItems = initItems();
		int listItemLength = listItems.size();
		for (int i=0; i<listItemLength; i++) {
			String itemName=listItems.get(i);
			if (itemName.equalsIgnoreCase(product)) {
				productImage.get(i).click();
				break;
			}
		}
		return new xperiaDetailPage();
	}
	
	public static cartPage navigateToCartPage(String product) {
		listItems = initItems();
		int listItemLength = listItems.size();
		for (int i=0; i<listItemLength; i++) {
			String itemName=listItems.get(i);
			if (listItems.contains(product)) { //using contains as checking the product in the entire item-list(available products)
				addToCartBtn.click();
				break;
			}
		}
		return new cartPage();	
	}
	
	/*
	public static void addComparingProducts(String product) {
		listItems = initItems();
		int listItemLength = listItems.size();
		for (int i=0; i<listItemLength; i++) {
			String myComparableProduct = listItems.get(i);
			if (myComparableProduct.equalsIgnoreCase(product)) {
				addCompareLink.get(i).click();
			}
		}
	}*/
	
	
	public static void addComparingProducts(ArrayList<String> products) {
		listItems = initItems();
		//int listItemLength = listItems.size();
		//System.out.println(listItems);
		Object[] myProd = products.toArray();
		String[] choosenProduct = Arrays.copyOf(myProd, myProd.length, String[].class);
		//System.out.println(choosenProduct);
		for (int i=0; i<myProd.length; i++) {
			//System.out.println(choosenProduct[i]);
			if (listItems.contains(choosenProduct[i])) {
				addCompareLink.get(i).click();
			}
		}
	}
	
	
	public static boolean isVisisbleCompareButton() {
		try {
			if(compareBtn.isDisplayed()) {
				return true;
			}
		}catch(NoSuchElementException e){
			return false;
		}
		return false;
		
	}
	
	public static compareProductPage navigateToProductComparePage() { //addComparingProducts() method should call before this one
		compareBtn.click();
		Set<String> windowHandler=driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		String parentWindow = it.next();
		String comparePage = it.next();
		driver.switchTo().window(comparePage);
		return new compareProductPage();
	}
	
	
	//Pop-up page actions === 
	
	
	
	
	
	/*
	
	public static String productComparePageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public static String productComparePageHeader() {
		String pageHeader = productCompareHeader.getText();
		return pageHeader;
	}
	
	public static ArrayList<String> comparePageDisplayProducts() {
		ArrayList<String> displayProductList = new ArrayList<String>();
		int productListLength = displayProducts.size();
		System.out.println(productListLength);
		for (int i=0; i<productListLength; i++) {
			displayProductList.add(displayProducts.get(i).getText());
		}
		System.out.println(displayProductList);
		return displayProductList;
	}
	
	public static String closingCompareProductPage() {
		closeBtn.click();
		for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
		String myTitle = driver.getTitle();
		return myTitle;
	}*/
	


	
	
	

}
