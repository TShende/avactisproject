package com.avactis.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement subcategory, category, product, addToCart;
	private String categoryXpath = "//div[@class='header-navigation']//a[contains(text(),'";
	private String subCategoryXpath = "//li[@class='dropdown dropdown-megamenu']//ul[@class='dropdown-menu']//li//a[contains(text(),'";
	private String productXpath ="//div[contains(@class,'product-item')]/form[@id='ProductForm_";
	private String addToCartButton = "//input[@class='en btn btn-primary button_add_to_cart input_submit']";
	@FindBy(xpath = "//a[@class='site-logo']")
	private WebElement avactisLogo;
	
	
	protected void goToCategory(Map<String, String> input) {
		
		avactisLogo.click();
		String Link = categoryXpath + input.get("Product Category").toString() + "')]";
		category = driver.findElement(By.xpath(Link));
		
		if((input.get("Product Sub Category")=="")) {
			logger.info("Category Choosen");
			category.click();
		}
		
		else if((input.get("Product Sub Category")!=null)) {
			mouseHover(category);
			subcategory = driver.findElement(By.xpath(subCategoryXpath+input.get("Product Sub Category")+"')]"));
			subcategory.click();
		}
		
	}
	
	protected void selectProduct(Map<String, String> input){
		goToCategory(input);
		product = driver.findElement(By.xpath(productXpath +input.get("Product Number").toString()+ "']/a[1]"));
		product.click();
	}
	
	public void addToCart(Map<String, String> input) throws InterruptedException {
		selectProduct(input);
		addToCart = driver.findElement(By.xpath(addToCartButton));
		addToCart.click();
	}
}
