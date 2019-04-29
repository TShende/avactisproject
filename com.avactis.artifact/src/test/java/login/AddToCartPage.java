package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AddToCartPage extends LoadableComponent<AddToCartPage>{

	@Override
	protected void isLoaded() throws Error {
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	
	WebDriver driver;
	String title;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void addtocart() {
	 Actions a = new Actions(driver);
	 WebElement apparel = driver.findElement(By.xpath("//a[contains(text(), 'Apparel')]"));
	 a.moveToElement(apparel).build().perform();
	 
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 WebElement notebooks = driver.findElement(By.xpath("//a[contains(text(), 'Notebooks')]"));
	 notebooks.click();
	 WebElement laptop = driver.findElement(By.xpath(".//*[contains(@href, 'Apple_MacBook_Laptop')]/following-sibling::div[2]/input[@value = 'Add To Cart']"));
	 laptop.click();	
	}
}
