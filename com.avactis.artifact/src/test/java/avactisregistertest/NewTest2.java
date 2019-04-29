package avactisregistertest;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import avactisregister.ConfigReader;
import avactisregister.ExcelFileReader;

public class NewTest2 {
  @Test(dataProvider = "data")
  public void f(Map<String, String> input) {
	 System.out.println(input.get("EmpID"));
  }
  
  @DataProvider(name = "data")
  public Object[][] dp() throws Exception {
	  return ExcelFileReader.getData(ConfigReader.getPropertyfromFile("avactis", "RegistrationdataExcel"),"Registration data");
  }
}
