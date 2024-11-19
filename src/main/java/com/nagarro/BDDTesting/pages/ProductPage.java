package com.nagarro.BDDTesting.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {

WebDriver driver;
	
	
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
    @FindBy(id="a-autoid-38-announce")
    WebElement AddreviewButton;
    
    @FindBy(xpath="//input[@type='submit'and @name='submit.add-to-cart']")
    WebElement AddtoCartButton;
    
    @FindBy(xpath="//input[@id='buy-now-button']")
    WebElement BuyNowButton;
    
    @FindBy(xpath="//div[@id='attach-added-to-cart-alert-and-image-area']/div/div/h4")
    WebElement confirm;

    public void ClickAddReview() {
    	AddreviewButton.click();
    }
 
    public String AddToCartMessage() {
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.elementToBeClickable(confirm));
    	return confirm.getText();
    }
    
    public void ClickAddToCart() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddtoCartButton);
    	AddtoCartButton.click();
    }
    
    public void ClickBuyNow() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BuyNowButton);
    	BuyNowButton.click();
    }
}