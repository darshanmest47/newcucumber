package Apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import configurations.Configreader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Apphooks {
	
	
	private Properties prop;
	private Properties browseProp;
	Configreader config;
	DriverFactory dfac;
	private WebDriver driver;
	
	@Before(order = 0)
	public void initProp() {
		config = new Configreader();
		prop = config.initialize();
		browseProp= config.browserInitialize();
		System.out.println("prop is "+ prop);
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		dfac = new DriverFactory();
		String browse = browseProp.getProperty("browserName");
		System.out.println("browse is "+browse);
		driver = dfac.initializeBrowser(browse);
		
	}
	
	@After(order = 0)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@After(order = 1)
	public void scrennShotCapture(Scenario sc) {
		if(sc.isFailed()) {
			String scname = sc.getName();
			 byte[] ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 sc.attach(ts, "image/png", scname);
		}
	}

}
