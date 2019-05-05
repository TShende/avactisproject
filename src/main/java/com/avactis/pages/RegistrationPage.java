package com.avactis.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement signin;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	@CacheLookup
	private WebElement register;

	@FindBy(xpath = "//input[@name = 'customer_info[Customer][Email]']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Password]']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='customer_info[Customer][RePassword]']")
	private WebElement retypePassword;

	@FindBy(xpath = "//input[@name='customer_info[Customer][FirstName]']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@name='customer_info[Customer][LastName]']")
	private WebElement lastname;

	@FindBy(xpath = "//select[@id='customer_info_Customer_Country']")
	private WebElement country;

	@FindBy(xpath = "//select[@id='customer_info_Customer_State']")
	private WebElement state;

	@FindBy(xpath = "//input[@name='customer_info[Customer][ZipCode]']")
	private WebElement zipcode;

	@FindBy(xpath = "//input[@name='customer_info[Customer][City]']")
	private WebElement city;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Streetline1]']")
	private WebElement addressline1;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Streetline2]']")
	private WebElement addressline2;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Phone]']")
	private WebElement contactphone;

	@FindBy(xpath = "//input[@class='en btn btn-primary btn-register input_submit']")
	private WebElement registerbutton;

	public void registerToAvactis(Map<String, String> input) {

		clickElement(signin);
		clickElement(register);
		setValue(email, input.get("Email"));
		setValue(password, input.get("Password"));
		setValue(retypePassword, input.get("Re-Type Password"));
		setValue(firstname, input.get("First Name"));
		setValue(lastname, input.get("Last Name"));
		selectElement(country, input.get("Country"));
		selectElement(state, input.get("State"));
		setValue(zipcode, input.get("Zip/Postal Code"));
		setValue(city, "City");
		setValue(addressline1, input.get("Address Line 1"));
		setValue(addressline2, input.get("Address Line 2"));
		setValue(contactphone, input.get("Contact Phone"));
		clickElement(registerbutton);
	}
}
}
