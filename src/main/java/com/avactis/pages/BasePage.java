package com.avactis.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avactis.utilities.ConfigReader;

public class BasePage extends LoadableComponent<BasePage> {

	private static final int TIMEOUT = 30;
	private static final int POLLING = 1000;
	static Logger logger = Logger.getLogger(BasePage.class);

	protected WebDriver driver;
	protected WebDriverWait wait;
	private String title = "Avactis Demo Store";

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);
		this.get();
		DOMConfigurator.configure("loggerxml.xml");
	}

	@Override
	protected void load() {
		driver.get(ConfigReader.getPropertyWithKey("Url"));
	}

	@Override
	protected void isLoaded() {
		assertEquals(driver.getTitle(), title, "Avactis page Not loaded Properely");
	}

	protected void selectElement(WebElement element, String key) {
		Select selectelement = new Select(element);
		selectelement.selectByVisibleText(key);
	}

	protected void clickElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	protected void setValue(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
	}
	
	protected void mouseHover(WebElement element) {
		Actions builder = new Actions(driver);
		Action mousehover = builder.moveToElement(element).build();
		mousehover.perform();
	}

}
