package com.avactis.avactistests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.avactis.utilities.DriverInstance;
import com.avactis.utilities.ExcelFileReader;

public class BaseTest {
	
	private WebDriver driver;
	
		@BeforeClass
		public void beforeSuite() {
		try {
			driver = new DriverInstance().get();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		}	
		
		@AfterClass
		public void teardown() {
			driver.quit();
		}
		
		public WebDriver getDriver() {
	        return driver;
	    }
		
		@DataProvider(name = "dp")
		public Object[][] dataprovider(String excelname, String sheetname ) throws Exception{
		  Object[][] ob = ExcelFileReader.getData(excelname, sheetname);
		  return ob;
		}
	
	
	
}
