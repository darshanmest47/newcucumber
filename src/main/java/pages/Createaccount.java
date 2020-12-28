package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SelectorUtility;

public class Createaccount {
	private WebDriver driver;
	
	public Createaccount(WebDriver driver) {
		this.driver = driver;
	}
	
	private By personal = By.xpath("//h3[contains(text(),'Your personal')]");
	private By mr = By.xpath("//input[@id='id_gender1']");
	private By fname = By.xpath("//input[@name='customer_firstname']");
	private By lname = By.xpath("//input[@name='customer_lastname']");
	private By email = By.xpath("//input[@id='email']");
	private By pwd = By.xpath("//input[@name='passwd']");
	private By days= By.xpath("//select[@name='days']/option");
	private By daysel = By.xpath("//select[@name='days']");
	private By months = By.xpath("//select[@name='months']/option");
	private By monthssel= By.xpath("//select[@name='months']");
	private By years = By.xpath("//select[@name='years']/option");
	private By yearssel = By.xpath("//select[@name='years']");
	private By facname = By.xpath("//div[@class='account_creation'][2]/p/input[@id='firstname']");
	private By laname = By.xpath("//div[@class='account_creation'][2]/p/input[@id='lastname']");
	private By comapny = By.xpath("//div[@class='account_creation'][2]/p/input[@id='company']");
	private By add1 = By.xpath("//div[@class='account_creation'][2]/p/input[@name='address1']");
	private By city = By.xpath("//div[@class='account_creation'][2]/p/input[@name='city']");
	private By state = By.xpath("//div[@class='account_creation'][2]/p/div[@class='selector']/select[@id='id_state']/option");
	private By statesel= By.xpath("//div[@class='account_creation'][2]/p/div[@class='selector']/select[@id='id_state']");
	private By zipcode = By.xpath("//div[@class='account_creation'][2]/p/input[@name='postcode']");
	private By country = By.xpath("//div[@class='account_creation'][2]/p/div/select[@id='id_country']/option");
	private By countrysel = By.xpath("//div[@class='account_creation'][2]/p/div/select[@id='id_country']");
	private By mphone = By.xpath("//div[@class='account_creation'][2]/p/input[@name='phone_mobile']");
	private By alias = By.xpath("//div[@class='account_creation'][2]/p/input[@name='alias']");
	private By register= By.xpath("//button[@name='submitAccount']");
	
	public boolean personalDisp() {
		return driver.findElement(personal).isDisplayed();
	}
	public void selectGender() {
		driver.findElement(mr).click();
	}
	
	public void enterFName(String name) {
		driver.findElement(fname).sendKeys(name);
	}
	public void enterLName(String last) {
		driver.findElement(lname).sendKeys(last);
	}
	
	public void enterEmail(String emailid) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(emailid);
	}
	public void enterPassword(String passwd) {
		driver.findElement(pwd).sendKeys(passwd);
	}
	
	public void enterDay(String day) {

	 List<WebElement> da = driver.findElements(days);
	 
SelectorUtility.selectDoubleNBSP(da, day);
	}
	
	public void enterMonth(String month) {
		driver.findElement(monthssel).click();
		 List<WebElement> mo = driver.findElements(months);
		 
	     SelectorUtility.selectSingleNBSP(mo, month);
		}
	
	
	public void enterYear(String year) {
		driver.findElement(yearssel).click();
		 List<WebElement> ye = driver.findElements(years);
		 
	SelectorUtility.selectDoubleNBSP(ye, year);
		}
	
	public void enterFNameaddress(String fname) throws InterruptedException {
		driver.findElement(facname).clear();
		Thread.sleep(2000);
		driver.findElement(facname).sendKeys(fname);
	}
	
	public void enterLNameaddress(String lname) throws InterruptedException {
		driver.findElement(laname).clear();
		Thread.sleep(2000);
		driver.findElement(laname).sendKeys(lname);
	}
	
	public void enterCompany(String company) throws InterruptedException {
		driver.findElement(comapny).clear();
		Thread.sleep(2000);
		driver.findElement(comapny).sendKeys(company);
	}
	
	public void enterAddress1(String address1) {
		driver.findElement(add1).sendKeys(address1);
	}
	
	public void enterCity(String city1) {
		driver.findElement(city).sendKeys(city1);
	}
	
	public void selectState(String stateadd) {
	
		
		List<WebElement> stateval = driver.findElements(state);
		
		SelectorUtility.selectNONBSP(stateval, stateadd);

	}
	
	public void enterZip(String zip) {
		driver.findElement(zipcode).sendKeys(zip);
	}
	
	public void selectCountry(String countryval) {
		
		List<WebElement> coun = driver.findElements(country);
		SelectorUtility.selectNONBSP(coun, countryval);
		
	}
	
	
	public void enterMobile(String mob) {
		driver.findElement(mphone).sendKeys(mob);
	}
	
	public void enterAlias(String als) {
		driver.findElement(alias).sendKeys(als);
	}
	
	public void clickRegister() {
		driver.findElement(register).click();
	}
	
}
