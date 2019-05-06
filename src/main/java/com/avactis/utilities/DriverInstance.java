package com.avactis.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverInstance {
	
	WebDriver driver = null;

	public WebDriver get() {

		String browser = ConfigReader.getPropertyfromFile("avactis", "browser");

		if (browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Workspace_new\\avactisproject\\avactisproject\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Workspace_new\\avactisproject\\avactisproject\\src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		}

		return driver;
	}

	public void close() {
		driver.quit();
	}

	
}
