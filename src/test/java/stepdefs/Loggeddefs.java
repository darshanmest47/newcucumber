package stepdefs;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

import configurations.Configreader;
import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Loginpage;
import pages.Useraccountpage;
import utilities.Excelreader;

public class Loggeddefs {
	
	Loginpage lp;
	Properties prop;
	Configreader cnf;
	Useraccountpage upage;
	 String useremail=null;
	
	@Before
	public void setUp() {
		lp = new Loginpage(DriverFactory.returnDriver());
		upage = new Useraccountpage(DriverFactory.returnDriver());
		cnf = new Configreader();
	   	prop = cnf.initialize();
	}
	

   @Given("^User is already on the login page$")
    public void user_is_already_on_the_login_page()  {
	   String title = lp.getTitlePage();
     System.out.println(title);
     System.out.println(prop.getProperty("Signup_title").equals(title));
    }
   
   @When("^User clicks on Signin button directly without entering any email$")
    public void user_clicks_on_signin_button_directly_without_entering_any_email()  {
    lp.clickSignin();
    }

    @Then("^An Error Message Should get displayed$")
    public void an_error_message_should_get_displayed()  {
    lp.errDisp();
    }
    
    
    
    
    
    
    
    
    @When("^User Enters the proper email address$")
    public void user_enters_the_proper_email_address() throws IOException  {
    	 useremail  = Excelreader.ExcelReader("E:\\ec5\\newcucu\\src\\main\\java\\Exceldata\\Randomdatagenerated.xlsx");
      System.out.println(useremail);
    	 
    	 lp.enterEmail1(useremail);
    }

    @Then("^User lands on the user account page$")
    public void user_lands_on_the_user_account_page()  {
     String title = upage.returnTitle();
     System.out.println(title);
    Assert.assertEquals(prop.getProperty("My_acc"), title);
    }

    @Then("^User lands on the the user registartion page$")
    public void user_lands_on_the_the_user_registartion_page()  {
     String title = lp.getTitlePage();
     System.out.println(title);
     Assert.assertEquals(prop.getProperty("Signup_title"), title);
    }

    @And("^User Enters the proper password$")
    public void user_enters_the_proper_password()  {
    	 lp.enterPasswd("DarshanKA47");
    }

    @When("^User Clicks on Signin button$")
    public void user_clicks_on_signin_button() {
       lp.clickSignin();
    }

    @And("^User clicks on Signout button$")
    public void user_clicks_on_signout_button() {
       upage.clickSignout();
    }

}
