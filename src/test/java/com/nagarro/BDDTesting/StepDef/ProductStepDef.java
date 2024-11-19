package com.nagarro.BDDTesting.StepDef;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.nagarro.BDDTesting.pages.HomePage;
import com.nagarro.BDDTesting.pages.ProductPage;
import com.nagarro.BDDTesting.pages.SearchPage;
import com.nagarro.BDDTesting.utilities.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef extends BaseTest{

	 HomePage home;
	SearchPage search;
	ProductPage productpage;
	WebDriver driver= getDriver();
	
	@Given("the user is on amazon home page")
	public void the_user_is_on_amazon_home_page() {
	    home= new HomePage(driver);
	}
	
	@When("the user search for a product {string}")
	public void the_user_search_for_a_product(String item) {
		home.searchProduct(item);
	}

	@When("the user navigates to the product page")
	public void the_user_navigates_to_the_product_page() {
		search= new SearchPage(driver);
	    search.openProductPage();
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    productpage= new ProductPage(driver);
	}

	@When("the user clicks Add to Cart button")
	public void the_user_clicks_add_to_cart_button() {
		productpage.ClickAddToCart();
	}

	@Then("the product should be added to the cart")
	public void the_product_should_be_added_to_the_cart() {
	   String message = productpage.AddToCartMessage();
	   Assert.assertEquals(message.toLowerCase(),"added to cart");
	}
	
	@When("the user clicks Buy now button")
	public void the_user_clicks_buy_now_button() {
	    productpage.ClickBuyNow();
	}

	@Then("the user should be redirected to login page")
	public void the_user_should_be_redirected_to_login_page() {
	    Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
	}
	
}
