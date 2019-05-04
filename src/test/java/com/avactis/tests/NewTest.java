package com.avactis.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.RegisterationPage;

public class NewTest extends BaseTest {

	private RegisterationPage ar;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		ar = new RegisterationPage(getDriver());
	}

	@Test(dataProvider = "dp")
	public void f(Map<String, String> input) {
		ar.registerToAvactis(input);
	}
}
