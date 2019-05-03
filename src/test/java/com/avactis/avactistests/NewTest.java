package com.avactis.avactistests;

import org.testng.annotations.Test;

import com.avactis.avactispages.AvactisRegisterPage;
import com.avactis.utilities.ConfigReader;
import com.avactis.utilities.ExcelFileReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.util.Map;

import org.testng.annotations.AfterMethod;

public class NewTest extends BaseTest {
	AvactisRegisterPage ar;
 @Test(dataProvider = "dp")
  public void f(Map<String, String> input) {
	  ar.registerToAvactis(input);
	    }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  ar = new AvactisRegisterPage(getDriver());
  }

  @AfterMethod
  public void afterMethod() {
	  
	 
  }
  
  @DataProvider(name = "dp")
  public Object[][] dataprovider() throws Exception{
	  Object[][] ob = ExcelFileReader.getData(ConfigReader.getPropertyfromFile("avactis", "RegistrationdataExcel"),"Registration data");
	  return ob;
  }

}
