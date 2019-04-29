package login;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginTest2 {
	public WebDriver driver;
	public AvactisLogin2 login;
	public   AddToCartPage add;
	
  @Test(priority = 1)
  public void f() {
	  login.dologin("tripti.shende@ymail.com", "123456"); 
  }
  
  @Test(priority = 2)
  public void g()
  {
	add = new AddToCartPage(driver);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	add.addtocart();
  }
  
  @BeforeClass
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver","src/test/resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		 login = new AvactisLogin2(driver);
		  login.get();
		
  }

  @AfterClass
  public void afterMethod() {
	  login.closeBrowser();
  }

}
