package com.nagarro.BDDTesting.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

WebDriver driver;
	
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement emailInputField;
    
    @FindBy(name="password")
    WebElement passwordInputField;
    
    @FindBy(xpath = "//*[@id='auth-error-message-box']/div/h4")
    List<WebElement> errorElements;
    
    public boolean login() {

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if (!errorElements.isEmpty()) {
            return false; 
        }
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return true;
    }
    
    public void enterEmail(String email) {
    	emailInputField.sendKeys(email);
    	emailInputField.submit();
    }
    
    public void enterPassword(String password) {
    	passwordInputField.sendKeys(password);
    	passwordInputField.submit();
    }
    
    public boolean isErrorDisplayed() {
    	return errorElements.size()>0;
    }
   
	
}
