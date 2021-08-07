package com.AutomationAsginmnt.Apps;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.AutomationAsignment.utility.ActionBot;
import com.AutomationAsignment.utility.ConfigReader;

public class ProductListingPage {

	RemoteWebDriver driver;
	int timeOutPeriod;
	/* All WebElements are identified by @FindBy annotation */

	public ProductListingPage(RemoteWebDriver driver) {

		this.driver = driver;

		// This initElements method will initialize all webelements

		PageFactory.initElements(driver, this);
		timeOutPeriod=Integer.parseInt(ConfigReader.getProperty("config.properties", "TIMEOUT"));

	}

	
	@FindBy(xpath= "//a[@title='Women']")
	WebElement WomenMenu;
	
	@FindBy(xpath= "//label[@for='layered_category_8']//a[contains(text(),'Dresses')]/../../div/span")
	WebElement DressCatagories;

	@FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_1']//li[1]/div/span")
	WebElement DressSize;
	
	
	
	@FindBy(xpath = "//input[@id='layered_id_feature_5']")
	WebElement CompositionCotton;
	
	@FindBy(xpath = "//div[@class='right-block']//span[@class='price product-price'][normalize-space()='$27.00']")
	WebElement Dollar27Product;
	
	@FindBys(@FindBy(xpath="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']//ul[@class='color_to_pick_list clearfix']/li"))
	List<WebElement> ColourMenu;
	
	@FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line hovered']//span[contains(text(),'Add to cart')]")
	WebElement AddToCartBtn;
	
	
	
	
	
	
	
	public void clickOnWomenMenu() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, WomenMenu, timeOutPeriod);
		ActionBot.focusAndclick(driver, WomenMenu);

	}

	public void checkFilters() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, DressCatagories, timeOutPeriod);
		ActionBot.focusAndclick(driver, DressCatagories);
		ActionBot.focusAndclick(driver, DressSize);
		ActionBot.focusAndclick(driver, CompositionCotton);

	}
    

	public void clickOnDollar27Product() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, Dollar27Product, timeOutPeriod);
		//ActionBot.focusAndclick(driver, Dollar27Product);
		Thread.sleep(10);
		for(WebElement COLOUR1:ColourMenu)
		{
			ActionBot.focusAndclick(driver, COLOUR1);
			break;
		}
		
		//ActionBot.focusAndclick(driver, AddToCartBtn);

	}
	
	
	
	
}
