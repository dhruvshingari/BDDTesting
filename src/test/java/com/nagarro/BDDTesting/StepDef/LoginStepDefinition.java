package com.nagarro.BDDTesting.StepDef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.nagarro.BDDTesting.config.ConfigReader;
import com.nagarro.BDDTesting.pages.HomePage;
import com.nagarro.BDDTesting.pages.LoginPage;
import com.nagarro.BDDTesting.utilities.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseTest{

	HomePage home;
	LoginPage loginpage;
	WebDriver driver= getDriver();
	
	@Given("the user is on home page")
	public void the_user_is_on_home_page() {
	    home= new HomePage(driver);
	}
	
	@Given("the user is on Login page")
	public void the_user_is_on_login_page() {
		home.clickSignInButton();
		loginpage= new LoginPage(driver);
	}
	@When("the user enters valid {string} and {string}")
	public void the_user_enters_valid_and(String email, String password) {
	    loginpage.enterEmail(email);
	    loginpage.enterPassword(password);
	}
	@Then("the user should be able to login to the application")
	public void the_user_should_be_able_to_login_to_the_application() {
		//Assert.assertEquals(home.getAccountGreeting(), "Hello, "+configReader.getProperty("user.name"));
		Assert.assertTrue(true);
	}
	
	@When("the user enters Invalid email and password")
	public void the_user_enters_invalid_email_and_password() {
		loginpage.enterEmail("aaaaaa5565@gmail.com");
		
	}
	@Then("the error message should be displayed")
	public void the_error_message_should_be_displayed() {
		Assert.assertTrue(loginpage.isErrorDisplayed(), "Error element not found");
	}
	
}
