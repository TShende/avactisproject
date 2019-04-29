package login;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import withpagefactory.AvactisLogin;

public class AvactisLogin2 extends LoadableComponent<AvactisLogin> {

	
	public WebDriver driver;
	public String url = "http://avactis:avactis%40123@sandbox.avactis.com/ketan479/";
	public String title = "Avactis Demo Store";
	
	
	public AvactisLogin2(WebDriver driver) {
			this.driver = driver;
	}
	
	@Override
	public void isLoaded() throws Error {
		assertEquals(driver.getTitle(),title,"Avactis page Not loaded Properely");
	}

	@Override
	public void load() {
		driver.get(url);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void dologin(String username1,String password1) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement signin = driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]"));
		signin.click();
		WebElement username = driver.findElement(By.id("account_sign_in_form_email_id"));
		username = wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(username1);
		WebElement password = driver.findElement(By.id("account_sign_in_form_passwd_id"));
		password.sendKeys(password1);
		WebElement button = driver.findElement(By.xpath( "//input[@class = 'btn btn-primary input_submit']"));
		button.click();
	}
	
}

