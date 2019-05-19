package com.avactis.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement signin;
	
	@FindBy(xpath = "//input[@id='account_sign_in_form_email_id']")
	private WebElement emailID;
	
	@FindBy(xpath = "//input[@id='account_sign_in_form_passwd_id']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-primary input_submit']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//span[@class='header_wel']/parent::span")
	private WebElement username;
	
	public void doSignIn(Map<String, String> input) {
		
		clickElement(signin);
		setValue(emailID, input.get("EmailID"));
		logger.info("Entering Username");
		setValue(password, input.get("Password"));
		logger.info("Entering Password");
		clickElement(signInButton);	
		logger.info("Signing In");
		logger.info("User is Signed In");

	}
	
	public String checkUserName() {
		
		String name = username.getText();
		name = name.substring(8, 14);
		System.out.println(name);
		return name;
		
	}
}
