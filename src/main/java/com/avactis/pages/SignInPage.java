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
<<<<<<< HEAD
	
	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement signin;
	
	@FindBy(xpath = "//input[@id='account_sign_in_form_email_id']")
	private WebElement emailID;
	
	@FindBy(xpath = "//input[@id='account_sign_in_form_passwd_id']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-primary input_submit']")
	private WebElement signInButton;
	
	public void doSignIn(Map<String, String> input) {
		
		clickElement(signin);
		setValue(emailID, input.get("EmailID"));
		setValue(password, input.get("Password"));
		clickElement(signInButton);		
=======

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement signin;

	@FindBy(xpath = "//input[@id='account_sign_in_form_email_id']")
	private WebElement emailID;

	@FindBy(xpath = "//input[@id='account_sign_in_form_passwd_id']")
	private WebElement password;

	@FindBy(xpath = "//input[@class='btn btn-primary input_submit']")
	private WebElement signInButton;

	public void doSignIn(Map<String, String> input) {

		clickElement(signin);
		setValue(emailID, input.get("EmailID"));
		setValue(password, input.get("Password"));
		clickElement(signInButton);
		/*
		 * signin.click();
		 * 
		 * emailID.sendKeys(input.get("EmailID")); password.sendKeys(input.get("Password"));
		 * 
		 * signInButton.click();
		 */
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
	}
}
