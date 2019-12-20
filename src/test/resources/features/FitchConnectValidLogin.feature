Feature: Login function test of www.fitchconnect.com 
	Description: Test to check whether a user can follow the process to login and logout of Member home page.

@FunctionalTest 
@SmokeTest 
@SanityTest 
Scenario: User enters valid username and password to enter authorized user Member home page 

	Given User opens test browser 
	When User goes to "https://www.fitchconnect.com" website 
	Then User clicks LOGIN
	Then User clicks Fitch Connect
	Then User is taken to Fitch Connect login page 
	Then User enters "Mia" as username 
	Then User enters "Connect1" as password 
	Then User clicks on Log In button 
	Then User is taken to member home page 
	Then User clicks log out 
	Then User closes test browser