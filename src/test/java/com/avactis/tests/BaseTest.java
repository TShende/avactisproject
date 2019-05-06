package com.avactis.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;





import com.avactis.utilities.DriverInstance;


public class BaseTest {

	private WebDriver driver;



	@BeforeClass
	public void beforeSuite() {
		driver = new DriverInstance().get();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
