package withpagefactory;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginTest {
	
	public AvactisLogin myLogin;
  
  @Test
  public void cartTest() {
	  myLogin.dologin("tripti.shende@ymail.com", "123456").addtocart();
  }
  
  
  
  
  @BeforeClass
  public void setUp() {
	  myLogin = new AvactisLogin();
		 myLogin.get();
  }

  @AfterClass
  public void tearDown() {
	  myLogin.closeBrowser();
  }

}
