Feature: Signup page check

Background:
	Given User is already on Login page
  	Then User verifies the title of the page
  	
  	And User verifies for the logo display
  	And User verifies for account creation text
  	When User clicks create account without email
  	Then Error text should get displayed
  	Then User enters the following username 
  	| darshanmesta47@gmail.com |
  	And clicks on the create account button
  	
Scenario Outline: To Register new User and Signout
	Given User is already on the createacc page
	Then User selects the gender
	And User enters the fname under perosnal information "<fname>"
	And User enters the lname under personal information "<lname>"
	And User enters the email under personal information "<email>"
	And User enters the password under personal information "<pwd>"
	And User selects the day "<Day>"
	And User selects the month "<Month>"
	And User selects the Year "<Year>"
	Then User enters the fname under address section "<fname>"
	And User enters the lname under address section "<lname>"
	And User enters the company under under address section "<company>"
	And User enters the address as "<Address1>"
	And User enters the city as "<City>"
	And User selects the state as "<State>"
	And User selects the zip code "<Zip>"
	And User selects the Country "<Country>"
	And User enters the Mobilenumber as "<Mphone>"
	And User clears and enters the alias "<Alias>"
	Then User clicks on the Register Button
	And User lands on the Useraccount page
	Then User verifies for the username
	And User verifies for the title of the page
	And User clicks on signout
	Then User lands on the registartion page
	
	
	
	
	
	Examples:
	| Day | Month | Year | Address1 | City | State | Zip | Country | Mphone |  Alias | fname | lname | company | email | pwd |
	| 24  | March  | 1995 | 500 atrium dr | Somerset | New Jersey  | 08873 | United States | 9019291929 | Home | Darshan | Mesta | Abcd | darshanmesta47@gmail.com | DarshanKA47 |
	
	
		
  	
  	
