package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_driver {


public static WebDriver driver;


 public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();


 	public WebDriver initializationDriver(String browser) {

 		if(browser.equalsIgnoreCase("chrome")) {
 			WebDriverManager.chromedriver().setup();
 			driver= new ChromeDriver();
 		}
 		else if(browser.equalsIgnoreCase("firefox")) {
 			WebDriverManager.firefoxdriver().setup();
 			driver= new FirefoxDriver();
 		}else {
 			System.out.println("invalid driver");
 		}

		return getdriver();

 	}


	public static synchronized WebDriver getdriver() {

		return tdriver.get();
	}

}
