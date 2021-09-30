package com.AutomationAsginmnt.Apps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationAsignment.utility.ActionBot;
import com.AutomationAsignment.utility.ConfigReader;

public class ProductDetailPage {

	RemoteWebDriver driver;
	int timeOutPeriod;
	/* All WebElements are identified by @FindBy annotation */

	public ProductDetailPage(RemoteWebDriver driver) {

		this.driver = driver;

		// This initElements method will initialize all webelements

		PageFactory.initElements(driver, this);
		timeOutPeriod = Integer.parseInt(ConfigReader.getProperty("config.properties", "TIMEOUT"));

	}

	

	@FindBy(xpath= "//span[@id='our_price_display']")
	WebElement ProductValue;
	
	@FindBy(xpath= "//select[@id='group_1']")
	WebElement SizeDropdown;


	@FindBy(xpath= "//span[normalize-space()='Add to cart']")
	WebElement AddToCartButton;

	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement Proceed_toCheckOutBtn;
	
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement Proceed_toCheckOutBtn2;
	
	
	public String getProductPrice() throws Exception {

	 ActionBot.waitForElementToBeDisplayed(driver, ProductValue, timeOutPeriod);
	 return ProductValue.getText()
;
	}

	public void changeSize(String size) throws Exception {

		Select sel=new Select(SizeDropdown);
		sel.selectByVisibleText(size);
		
	}
    
	public void clickOnAddtoCartButton() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, AddToCartButton, timeOutPeriod);
		ActionBot.focusAndclick(driver, AddToCartButton);
		

	}
	
	public void clickOnProceedCheckout() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, Proceed_toCheckOutBtn, timeOutPeriod);
		ActionBot.focusAndclick(driver, Proceed_toCheckOutBtn);
		

	}

	
	public void clickOnProceedCheckout2() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, Proceed_toCheckOutBtn2, timeOutPeriod);
		ActionBot.focusAndclick(driver, Proceed_toCheckOutBtn2);
		

	}

}
