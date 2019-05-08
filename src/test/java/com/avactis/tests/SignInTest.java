package com.avactis.tests;

import java.util.Map;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.avactis.pages.SignInPage;
import com.avactis.utilities.ExcelFileReader;


public class SignInTest extends BaseTest {

	private SignInPage sp;

	@BeforeMethod
	public void beforeMethod() {
		sp = new SignInPage(getDriver());
	}

	@Test(dataProvider = "dp")
	public void f(Map<String, String> input) {
		sp.doSignIn(input);

	}
	
	@DataProvider(name = "dp")
	public Object[][] dataprovider() throws Exception {
		return ExcelFileReader.getData("SignIn", "SignIn_Data_Positive");
	}



}
