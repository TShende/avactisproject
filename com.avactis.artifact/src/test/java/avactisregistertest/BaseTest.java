package avactisregistertest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import avactisregister.DriverInstance;

public class BaseTest {
	
	private WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		
		DriverInstance dr = new DriverInstance();
		try {
			driver = dr.getDriverInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}	
	
	
	@AfterSuite
	public void teardown() {
		driver.close();
	}
	
	public WebDriver getDriver() {
        return driver;
    }
}
