package com.avactis.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.SignInPage;

public class SignInTest extends BaseTest {

	private SignInPage sp;

	@BeforeClass
	public void provideExcelDetails() {
		excelName = "SignIn";
		sheetName = "SignIn Data";
	}

	@BeforeMethod
	public void beforeMethod() {
		sp = new SignInPage(getDriver());
	}

	@Test(dataProvider = "dp")
	public void f(Map<String, String> input) {
		sp.doSignIn(input);
	}

}
