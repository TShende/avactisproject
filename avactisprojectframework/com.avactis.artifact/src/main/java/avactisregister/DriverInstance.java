package avactisregister;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	
WebDriver driver = null;

public WebDriver getDriverInstance() throws Exception {
	
String browser;
browser =	ConfigReader.getPropertyfromFile("avactis", "browser");

	if(browser.equalsIgnoreCase("CHROME")) {
		WebDriverManager.getInstance(CHROME).setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	else if(browser.equalsIgnoreCase("IE")) {
		WebDriverManager.getInstance(IEXPLORER).setup();
		driver = new InternetExplorerDriver();
		return driver;
	}
return driver;
}
	
public void close()
{
	driver.quit();
}
	
	

}
