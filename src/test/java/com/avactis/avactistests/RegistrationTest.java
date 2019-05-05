package com.avactis.avactistests;

import org.testng.annotations.Test;

import com.avactis.pages.RegistrationPage;
import com.avactis.utilities.ExcelFileReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.util.Map;

public class RegistrationTest extends BaseTest {
	
	private RegistrationPage ar;
	
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  ar = new RegistrationPage(getDriver());
	  }
	  
	  @Test(dataProvider = "dp")
	  public void f(Map<String, String> input) {
		  ar.registerToAvactis(input);
	  }

	  @DataProvider(name = "dp")
	  public Object[][] dataprovider() throws Exception{
		  Object[][] ob = ExcelFileReader.getData("Registration", "Registration data");
		  return ob;
	  }

}
