package com.avactis.utilities;

//TODO: don't use this library, write own code to call to drivers.
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
<<<<<<< HEAD
	
	WebDriver driver = null;
=======
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git

<<<<<<< HEAD
	public WebDriver get() throws Exception {
	
		String browser=	ConfigReader.getPropertyfromFile("avactis", "browser");
=======
	WebDriver driver = null;
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git

<<<<<<< HEAD
		if(browser.equalsIgnoreCase("CHROME")) {
		WebDriverManager.getInstance(CHROME).setup();
		driver = new ChromeDriver();
=======
	public WebDriver get() {

		String browser = ConfigReader.getPropertyfromFile("avactis", "browser");

		if (browser.equalsIgnoreCase("CHROME")) {
			WebDriverManager.getInstance(CHROME).setup();
			driver = new ChromeDriver();
			return driver;
		} else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.getInstance(IEXPLORER).setup();
			driver = new InternetExplorerDriver();
			return driver;
		}
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
		return driver;
<<<<<<< HEAD
		}else if(browser.equalsIgnoreCase("IE")) {
		WebDriverManager.getInstance(IEXPLORER).setup();
		driver = new InternetExplorerDriver();
		return driver;
		}
		return driver;
=======
	}

	public void close() {
		driver.quit();
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
	}
<<<<<<< HEAD
	
	public void close(){
		driver.quit();
	}
	
	
=======
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git

}
