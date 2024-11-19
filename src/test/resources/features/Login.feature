@Login
Feature: Login to the application

  @ValidLogin
	Scenario: User should be able to login to the application with valid credentials
	Given the user is on home page
	Given the user is on Login page 
	When the user enters valid <email> and <password>
	Then the user should be able to login to the application
	
	Examples:
    | email| password|
    | "7009812052" | "12Jan@2002" |
	
  @InvalidLogin
  Scenario: User should not be able to login to the application with Invalid credentials
	Given the user is on home page
	Given the user is on Login page 
	When the user enters Invalid email and password
	Then the error message should be displayed
	
	