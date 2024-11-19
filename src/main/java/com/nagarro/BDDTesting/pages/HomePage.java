package com.nagarro.BDDTesting.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;
    
    @FindBy(id = "nav-orders")  
    WebElement returnsAndOrders;
    
    @FindBy(id="nav-link-accountList-nav-line-1")
    WebElement SignInButton;
    
    @FindBy(id="nav-logo-sprites")
    WebElement LogoButton;
    
    @FindBy(id="glow-ingress-line2")
    WebElement Pincode;
    
    @FindBy(id = "GLUXZipUpdateInput")
    WebElement PincodeInputField;
    
    @FindBy(xpath="//*[@id=\'GLUXZipUpdate\']/span/input")
    WebElement PinApplyButton;
    
    @FindBy(id="nav-link-accountList-nav-line-1")
    WebElement accountName;
    
    @FindBy(xpath="//*[@id=\"nav-xshop\"]/a[1]")
    WebElement FreshButton;
    
    
    public void clickReturnsAndOrders() {
        returnsAndOrders.click();
    }

    public void clickChangePincodeButton() {
    	Pincode.click();
    }
    public String displayPincode(String pincode)  {
   
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.textToBePresentInElement(Pincode," "+pincode));
    	// Now capture the updated text
    	String updatedText = Pincode.getText();
    	return updatedText;
    }
    public void EnterNewPincodeAndSubmit(String pincode) {
    	PincodeInputField.sendKeys(pincode);
    	PinApplyButton.click();
    }
    public void clickLogoButton() {
    	LogoButton.click();
    }
    
    public void clickSignInButton() {
    	SignInButton.click();
    }
     
    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }
    
    public void clickFreshButton() {
    	FreshButton.click();
    }
    
    public String getAccountGreeting() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement greetingElement = wait.until(ExpectedConditions.visibilityOf(accountName));
        return greetingElement.getText();
    }
    
}
