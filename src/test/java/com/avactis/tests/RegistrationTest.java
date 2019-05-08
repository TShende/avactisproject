package com.avactis.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.avactis.pages.RegistrationPage;
import com.avactis.utilities.ExcelFileReader;

public class RegistrationTest extends BaseTest {

	private RegistrationPage ar;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		ar = new RegistrationPage(getDriver());
	}

	@Test(dataProvider = "dp")
	public void f(Map<String, String> input) {
		System.out.println(input);
		ar.registerToAvactis(input);
	}


	
	@DataProvider(name = "dp")
	public Object[][] dataprovider() throws Exception {
		return ExcelFileReader.getData("Registration", "Registration data");
	}
	

}

