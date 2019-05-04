package com.avactis.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.avactis.utilities.ConfigReader;
import com.avactis.utilities.DriverInstance;
import com.avactis.utilities.ExcelFileReader;

public class BaseTest {

	private WebDriver driver;

	@BeforeClass
	public void beforeSuite() {
		new DriverInstance().get();
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}

	@DataProvider(name = "dp")
	public Object[][] dataprovider() throws Exception {
		return ExcelFileReader.getData(ConfigReader.getPropertyfromFile("avactis", "RegistrationdataExcel"), "Registration data");
	}
}
