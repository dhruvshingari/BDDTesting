package com.nagarro.BDDTesting.StepDef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.nagarro.BDDTesting.pages.HomePage;
import com.nagarro.BDDTesting.utilities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDef extends BaseTest{
	
	HomePage home;
	WebDriver driver= getDriver();

	@Given("the user is present on home page of amazon")
	public void the_user_is_present_on_home_page_of_amazon() {
		  home= new HomePage(driver);
	}

	@When("the user click the change pincode button")
	public void the_user_click_the_change_pincode_button() {
	    home.clickChangePincodeButton();
	}

	@When("the user enters a valid pincode {string} and submits")
	public void the_user_enters_a_valid_pincode_and_submits(String pincode) {
	    home.EnterNewPincodeAndSubmit(pincode);
	}

	@Then("the displayed pincode should get changed to {string}")
	public void the_displayed_pincode_should_get_changed(String pincode) {
		String result=home.displayPincode(pincode);
        Assert.assertTrue(result.contains(pincode));
	}
	
}
