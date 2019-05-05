package com.avactis.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

	private RegistrationPage ar;

	@BeforeClass
	public void provideExcelDetails() {
		excelName = "Registration";
		sheetName = "Registration data";
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		ar = new RegistrationPage(getDriver());
	}

	@Test(dataProvider = "dp")
	public void f(Map<String, String> input) {
		System.out.println(input);
		ar.registerToAvactis(input);
	}
}
