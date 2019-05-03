package com.avactis.avactistests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.avactis.utilities.DriverInstance;

public class BaseTest {
	
	private WebDriver driver;
	
	@BeforeClass
	public void beforeSuite() {
		
		DriverInstance dr = new DriverInstance();
		try {
			driver = dr.getDriverInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}	
	
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	public WebDriver getDriver() {
        return driver;
    }
}
