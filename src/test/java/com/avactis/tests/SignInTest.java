package com.avactis.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.SignInPage;

public class SignInTest extends BaseTest {

	SignInPage sp;

	@BeforeMethod
	public void beforeMethod() {
		sp = new SignInPage(getDriver());
	}

	@Test(dataProvider = "dp")
	public void f(Map<String, String> input) {
		sp.doSignIn(input);
	}

}
