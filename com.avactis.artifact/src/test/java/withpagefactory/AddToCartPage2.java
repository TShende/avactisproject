package withpagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AddToCartPage2 extends LoadableComponent<AddToCartPage2>{
	WebDriver driver;
	
	public AddToCartPage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(xpath = "//a[contains(text(), 'Notebooks')]")
	@CacheLookup
	private WebElement notebooks;

	@FindBy(xpath = ".//*[contains(@href, 'Apple_MacBook_Laptop')]/following-sibling::div[2]/input[@value = 'Add To Cart']")
	@CacheLookup
	private WebElement laptop;
	
	public void addtocart() {
		notebooks.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		laptop.click();
	}
	
}
