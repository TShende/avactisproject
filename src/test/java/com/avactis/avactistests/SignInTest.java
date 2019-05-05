package com.avactis.avactistests;

import org.testng.annotations.Test;

import com.avactis.pages.SignInPage;
import com.avactis.utilities.ExcelFileReader;
import org.testng.annotations.BeforeMethod;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class SignInTest extends BaseTest{
	
	private SignInPage sp;
	
	 @BeforeMethod
	  public void beforeMethod() {
		 sp = new SignInPage(getDriver());
	  }
	
	 @Test(dataProvider = "dp")
	 public void f(Map<String, String> input) {
		 sp.doSignIn(input);
	  
	 }


	 @DataProvider
	 public Object[][] dp() throws Exception {
		 Object[][] ob = ExcelFileReader.getData("SignIn", "SignIn Data");
		 return ob;
	 }
  
}
