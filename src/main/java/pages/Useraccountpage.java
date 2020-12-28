package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Useraccountpage {

	private WebDriver driver;
	
	public Useraccountpage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By signout = By.xpath("//a[@class='logout']");
	private By username = By.xpath("//a/span[contains(text(),'Darshan')]");
	
	
	public String returnTitle() {
		return driver.getTitle();
	}
	
	public boolean userNameDisp() {
		return driver.findElement(username).isDisplayed();
	}
	
	public void clickSignout() {
		driver.findElement(signout).click();
	}
	
}
