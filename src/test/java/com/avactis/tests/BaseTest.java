package com.avactis.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.avactis.utilities.DriverInstance;
import com.avactis.utilities.ExcelFileReader;

public class BaseTest {

	private WebDriver driver;
	public String excelName;
	public String sheetName;

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

	@DataProvider(name = "dp")
	public Object[][] dataprovider() throws Exception {
		return ExcelFileReader.getData(excelName, sheetName);
	}
}
