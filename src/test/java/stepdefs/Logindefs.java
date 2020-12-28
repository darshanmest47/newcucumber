package stepdefs;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import Exceldata.ExcelWriter;
import configurations.Configreader;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Createaccount;
import pages.Loginpage;
import pages.Useraccountpage;
import utilities.Randomdatautility;

public class Logindefs {
	
	
	Loginpage lp;
	Properties prop;
	Configreader cnf;
	Createaccount cacc;
	Useraccountpage upage;
	String emailid;
	
	
	@Before
	public void setUp() {
		lp= new Loginpage(DriverFactory.returnDriver());
	 	cnf = new Configreader();
	   	prop = cnf.initialize();
	}

   @Given("^User is already on Login page$")
    public void user_is_already_on_login_page()  {
	  
	   
	
		  System.out.println("user is already present");
	 
  
   
    }

    @Then("^User verifies the title of the page$")
    public void user_verifies_the_title_of_the_page()  {
      String title1 = lp.getTitlePage();
      System.out.println(title1);
//      System.out.println(prop.getProperty("Signup_title"));
//      System.out.println(title1.equals(prop.getProperty("Signup_title")) );
      Assert.assertTrue(title1.equals(prop.getProperty("Signup_title")));
    }

    @And("^User verifies for the logo display$")
    public void user_verifies_for_the_logo_display()  {
    	System.out.println(lp.logoDisp());
        Assert.assertTrue(lp.logoDisp());
    }
    
    
    @Then("^User enters the following username$")
    public void user_enters_the_username_something(DataTable table) throws InterruptedException, InvalidFormatException, IOException  {
    	List<List<String>> users = table.asLists(String.class);
    	for(List<String> user:users) {
//    		lp.enterEmail(user.get(0));
    		emailid = Randomdatautility.getRandomEmail();
    		lp.enterEmail(emailid);
//  		ExcelWriter.writeData(emailid,"*** Last generated email ***");
    		
    	}
    }

    @And("^User verifies for account creation text$")
    public void user_verifies_for_account_creation_text()  {
      boolean isdisp = lp.createDisp();
      System.out.println(isdisp);
    }

    @And("^clicks on the create account button$")
    public void clicks_on_the_create_account_button()  {
    	lp.clickSubmit();
    	cacc = new Createaccount(DriverFactory.returnDriver());
    }
    
    @When("^User clicks create account without email$")
    public void user_clicks_create_account_without_email()  {
       lp.clickSubmit();
    }

    @Then("^Error text should get displayed$")
    public void error_text_should_get_displayed()  {
    	
      lp.erroDisp();
    }
    
    
    
    //Registration
    
    
    @Given("^User is already on the createacc page$")
    public void user_is_already_on_the_createacc_page()  {
      boolean disp = cacc.personalDisp();
      if(disp) {
    	  System.out.println("****************************");
    	  System.out.println("user is on create account page");
    	  System.out.println("****************************");
      }
    }
    
    
    @Then("^User selects the gender$")
    public void user_selects_the_gender()  {
       cacc.selectGender();
    }

    @Then("^User enters the fname under address section \"([^\"]*)\"$")
    public void user_enters_the_fname_under_address_section_something(String fname) throws InterruptedException  {
      System.out.println(fname);
      cacc.enterFNameaddress(fname);
    }

    @Then("^User clicks on the Register Button$")
    public void user_clicks_on_the_register_button()  {
       cacc.clickRegister();
       upage = new Useraccountpage(DriverFactory.returnDriver());
    }

    @And("^User enters the fname under perosnal information \"([^\"]*)\"$")
    public void user_enters_the_fname_under_perosnal_information_something(String fname)  {
       System.out.println(fname);
       cacc.enterFName(fname);
    }

    @And("^User enters the lname under personal information \"([^\"]*)\"$")
    public void user_enters_the_lname_under_personal_information_something(String lname)  {
    System.out.println(lname);
    cacc.enterLName(lname);
    }

    @And("^User enters the email under personal information \"([^\"]*)\"$")
    public void user_enters_the_email_under_personal_information_something(String email)  {
   cacc.enterEmail(emailid);
    }

    @And("^User enters the password under personal information \"([^\"]*)\"$")
    public void user_enters_the_password_under_personal_information_something(String pwd)  {
       cacc.enterPassword(pwd);
    }

    @And("^User selects the day \"([^\"]*)\"$")
    public void user_selects_the_day_something(String day)  {
   
      cacc.enterDay(day);
    }

    @And("^User selects the month \"([^\"]*)\"$")
    public void user_selects_the_month_something(String month)  {
   
     cacc.enterMonth(month);
    }

    @And("^User selects the Year \"([^\"]*)\"$")
    public void user_selects_the_year_something(String year)  {
    
      cacc.enterYear(year);
    }

    @And("^User enters the lname under address section \"([^\"]*)\"$")
    public void user_enters_the_lname_under_address_section_something(String lname) throws InterruptedException  {
       System.out.println(lname);
       cacc.enterLNameaddress(lname);
    }

    @And("^User enters the company under under address section \"([^\"]*)\"$")
    public void user_enters_the_company_under_under_address_section_something(String company) throws InterruptedException  {
    	System.out.println(company);
    	cacc.enterCompany(company);
    }

    @And("^User enters the address as \"([^\"]*)\"$")
    public void user_enters_the_address_as_something(String address1)  {
       System.out.println(address1);
       cacc.enterAddress1(address1);
    }

    @And("^User enters the city as \"([^\"]*)\"$")
    public void user_enters_the_city_as_something(String city)  {

 cacc.enterCity(city);
    }

    @And("^User selects the state as \"([^\"]*)\"$")
    public void user_selects_the_state_as_something(String state)  {
       
        cacc.selectState(state);
    }

    @And("^User selects the zip code \"([^\"]*)\"$")
    public void user_selects_the_zip_code_something(String zip)  {
       System.out.println(zip);
       cacc.enterZip(zip);
    }

    @And("^User selects the Country \"([^\"]*)\"$")
    public void user_selects_the_country_something(String country)  {
    	
    	cacc.selectCountry(country);
    }

    @And("^User enters the Mobilenumber as \"([^\"]*)\"$")
    public void user_enters_the_mobilenumber_as_something(String mphone) {
     System.out.println(mphone);
     cacc.enterMobile(mphone);
    }

    @And("^User clears and enters the alias \"([^\"]*)\"$")
    public void user_clears_and_enters_the_alias_something(String alias) throws InterruptedException  {
       System.out.println(alias);
       Thread.sleep(10000);
       cacc.enterAlias(alias);
    }
    
    
    // User account page
    
    @Then("^User verifies for the username$")
    public void user_verifies_for_the_username()  {
    	boolean disp = upage.userNameDisp();
    	Assert.assertTrue(disp);
    }

    @Then("^User lands on the registartion page$")
    public void user_lands_on_the_registartion_page()  {
       String title = upage.returnTitle();
       System.out.println(title +" is from reg page ");
       if(title.equals(prop.getProperty("Signup_title"))) {
    	   System.out.println("User is on the registartion page");
       }
    }

    @And("^User lands on the Useraccount page$")
    public void user_lands_on_the_useraccount_page() throws InvalidFormatException, IOException  {
        String title = lp.getTitlePage();
        System.out.println(title+" is from useracc page");
        Assert.assertEquals(prop.getProperty("My_acc"), title);
  		ExcelWriter.writeData(emailid,"*** Last generated email ***");
    }

    @And("^User verifies for the title of the page$")
    public void user_verifies_for_the_title_of_the_page() {
    	String title = upage.returnTitle();
    	System.out.println(title+" is from page");
    	Assert.assertEquals(prop.getProperty("My_acc"), title);
    }

    @And("^User clicks on signout$")
    public void user_clicks_on_signout()  {
     upage.clickSignout();
    }

   



}
