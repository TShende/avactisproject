package avactisregistertest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import avactisregister.ConfigReader;
import avactisregister.ExcelFileReader;
import avactisregister.SignInPage;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class SignInTest extends BaseTest{
	
	SignInPage sp;
	
  @Test(dataProvider = "dp")
  public void f(Map<String, String> input) {
	  sp.doSignIn(input);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  sp = new SignInPage(getDriver());
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() throws Exception {
	  Object[][] ob = ExcelFileReader.getData(ConfigReader.getPropertyfromFile("avactis", "SignInDataExcel"),"SignIn data");
	  return ob;
    };
  
}
