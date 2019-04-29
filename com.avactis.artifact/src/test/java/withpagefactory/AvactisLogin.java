package withpagefactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvactisLogin extends LoadableComponent<AvactisLogin> {

	
	public WebDriver driver;
	public String url = "http://avactis:avactis%40123@sandbox.avactis.com/ketan479/";
	public String title = "Avactis Demo Store";
	
	
	public AvactisLogin () {
		  System.setProperty("webdriver.gecko.driver","src/test/resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			PageFactory.initElements(driver, this );
	}
	
	@Override
	public void isLoaded() throws Error {
		assertEquals(driver.getTitle(),title,"Avactis page Not loaded Properely");
	}

	@Override
	public void load() {
		driver.get(url);
	}
	
	@FindBy(xpath = "//a[contains(text(), 'Sign In')]")
	@CacheLookup
	private WebElement signin;

	@FindBy(id = "account_sign_in_form_email_id")
	@CacheLookup
	private WebElement username;
	
	@FindBy(id = "account_sign_in_form_passwd_id")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath = "//input[@class = 'btn btn-primary input_submit']")
	@CacheLookup
	private WebElement button;
	

	
	public void closeBrowser() {
		driver.quit();
	}
	
	public AddToCartPage2 dologin(String username1,String password1) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		signin.click();
		username = wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(username1);
		password.sendKeys(password1);
		button.click();
		AddToCartPage2 cart = new AddToCartPage2(driver);
		return cart;
		
	}
	
}

