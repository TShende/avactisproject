package com.avactis.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.avactis.pages.MainPage;
import com.avactis.utilities.ExcelFileReader;


public class AddToCartTest extends BaseTest{
	
	private MainPage mp;
	
	@BeforeMethod
	public void beforeMethod() {
		mp = new MainPage(getDriver());
	}
	
	@Test(dataProvider = "dp")
	public void f(Map<String, String> input) {
		mp.addToCart(input);
	}
	
	@DataProvider(name = "dp")
	public Object[][] dataprovider() throws Exception {
		return ExcelFileReader.getData("SignIn", "Product Details");
	}
}
