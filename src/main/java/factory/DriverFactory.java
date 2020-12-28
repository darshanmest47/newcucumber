package factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver>tls= new ThreadLocal<WebDriver>();
	public Properties prop;

	
	public WebDriver initializeBrowser(String browser) {
	 System.out.println("Tests are Running on "+browser);
		 
		 if(browser.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 tls.set(new ChromeDriver());
		 }
		 else if(browser.equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			 tls.set(new FirefoxDriver());
		 }
		 else {
			 System.out.println("Unsupported Browser");
		 }
		 returnDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		 returnDriver().manage().deleteAllCookies();
		 returnDriver().manage().window().maximize();
		 
		 return returnDriver();
	 
	}
	
	public static synchronized WebDriver returnDriver() {
		return tls.get();
	}
	
	
	
	

}
