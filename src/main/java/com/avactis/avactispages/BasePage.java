package com.avactis.avactispages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avactis.utilities.ConfigReader;

public class BasePage extends LoadableComponent<BasePage> {
	
	  private static final int TIMEOUT = 30;
	  private static final int POLLING = 100;

	  protected WebDriver driver;
	  protected WebDriverWait wait;
	  public String title = "Avactis Demo Store";
	
	  public BasePage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        PageFactory.initElements(driver, this);
	        this.get();
	  }
	
	@Override
	protected void load() {
		try {
			driver.get(ConfigReader.getPropertyWithKey("Url"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),title,"Avactis page Not loaded Properely");
		
	}
	
	protected void selectElement(WebElement element, String key) {
		Select selectelement = new Select(element);
		selectelement.selectByVisibleText(key);
		
	}
}
