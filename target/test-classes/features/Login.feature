Feature: Login feature

Background:
   Given User is already on the login page


Scenario: To Verify the Login Functionality with Error
	
	When User clicks on Signin button directly without entering any email
	Then An Error Message Should get displayed
	
Scenario: To Verify the Login Functionality with proper credentials
	When User Enters the proper email address
	And User Enters the proper password
	When User Clicks on Signin button	
	Then User lands on the user account page
	And User clicks on Signout button
	Then User lands on the the user registartion page
	
	
	
