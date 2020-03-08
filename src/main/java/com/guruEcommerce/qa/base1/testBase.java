package com.guruEcommerce.qa.base1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.guruEcommerce.qa.util.WebEventListener;
import com.guruEcommerce.qa.util.testUtil;

public class testBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public testBase() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/bimanb/Documents/2020/learning/guruEcommerce/src/main/java/com/guruEcommerce/qa/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void Initialization() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/bimanb/Documents/2020/learning/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "/Users/bimanb/Documents/2020/learning/geckodriver");
			driver = new FirefoxDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}