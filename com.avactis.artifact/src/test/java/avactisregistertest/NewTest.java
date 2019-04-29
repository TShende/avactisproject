package avactisregistertest;

import org.testng.annotations.Test;

import avactisregister.AvactisRegisterPage;
import avactisregister.ConfigReader;
import avactisregister.ExcelFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.util.Map;

import org.testng.annotations.AfterMethod;

public class NewTest {
	AvactisRegisterPage ar;
  @Test(dataProvider = "dp")
  public void f(Map<String, String> input) {
	  ar.registerToAvactis(input);
	    }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	
	ar = new AvactisRegisterPage();
	ar.get();
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
