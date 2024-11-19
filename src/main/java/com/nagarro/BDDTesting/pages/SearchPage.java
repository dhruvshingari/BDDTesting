package com.nagarro.BDDTesting.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

WebDriver driver;
	
	
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(partialLinkText = "Apple iPhone 16 (128 GB) - Teal")
    WebElement ProductLink;
    
    @FindBy(id="s-result-sort-select")
    WebElement sortDropDown;
    
    @FindBy(how = How.CLASS_NAME, using = "s-result-item")
    List<WebElement>  result;
    
    public void openProductPage() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ProductLink);
    	ProductLink.click();
    }
    
	public boolean isDisplayed() {
		return result.size()>0;
	}
	
	public void sort() {
		Select dropDown= new Select(sortDropDown);
		dropDown.selectByIndex(2);
		//dropDown.selectByValue("Price: High to Low");
	}
}
