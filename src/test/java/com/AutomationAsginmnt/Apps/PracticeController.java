package com.AutomationAsginmnt.Apps;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.AutomationAsignment.utility.ConfigReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class PracticeController{
	static Logger logger = Logger.getLogger(PracticeController.class);
	private String appURL = null;
	AutomationPracticePOJO Practicepojo=new AutomationPracticePOJO();
	PracticeController(){
		
		Practicepojo.setUiProductCost(ConfigReader.getProperty("UI.properties", "PRODUCT_COST"));
		Practicepojo.setUiSize(ConfigReader.getProperty("UI.properties", "PRODUCT_SIZE"));
		Practicepojo.setUiEmail(ConfigReader.getProperty("UI.properties", "EMAIL"));
		Practicepojo.setUiPassword(ConfigReader.getProperty("UI.properties", "PASSWORD"));
		Practicepojo.setUisucessMessage(ConfigReader.getProperty("UI.properties", "SUCESSMESSAGE"));
	}

	public void launchApplication(RemoteWebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		appURL = ConfigReader.getProperty("UI.properties", "APPURL");
		driver.get(appURL);

	}

	public void ProductListingFlow(RemoteWebDriver driver, ExtentTest test)
			throws Exception {
		try {
			logger.info("Start Testcase ==>ProductListingFlow");
			test.log(Status.INFO,"In Product Listing Page");
			ProductListingPage plp=new ProductListingPage(driver);
			test.log(Status.INFO, "Clicked on Women Catagores");
			plp.clickOnWomenMenu();
			test.log(Status.INFO, "Check 3 Filters");
			plp.checkFilters();
			test.log(Status.INFO, "Click on $27 Product");
			plp.clickOnDollar27Product();
			logger.info("Finish Testcase ==>ProductListingFlow");
		} catch (Exception e) {
			throw new Exception("Error occured in ProductListingFlow" + e.getMessage());
		}

	}
	
	public void ProductDetailsFlow(RemoteWebDriver driver, AutomationPracticePOJO weather,ExtentTest test)
			throws Exception {
		try {
			logger.info("Start Testcase ==>ProductDetailsFlow");
			test.log(Status.INFO, "In Product Details Page");
			ProductDetailPage pdp = new ProductDetailPage(driver);
			Assert.assertEquals(true, pdp.getProductPrice().contains(Practicepojo.getUiProductCost()));
			test.log(Status.PASS, "Amount Validation Sucessfull in Product Deatils Page");
			pdp.changeSize(Practicepojo.getUiSize());
			pdp.clickOnAddtoCartButton();
			pdp.clickOnProceedCheckout();
			pdp.clickOnProceedCheckout2();
			logger.info("Finish Testcase ==>ProductDetailsFlow");
		} catch (Exception e) {
			throw new Exception("Error occured in ProductDetailsFlow" + e.getMessage());
		}}
		
		
		public void AuthenticationFlow(RemoteWebDriver driver, AutomationPracticePOJO weather,ExtentTest test)
				throws Exception {
			try {
				logger.info("Start Testcase ==>AuthenticationFlow");
				test.log(Status.INFO, "In Authentication Page");
				AuthenticationPage aup=new AuthenticationPage(driver);
				aup.enterEmail(Practicepojo.getUiEmail());
				aup.enterPassword(Practicepojo.getUiPassword());
				aup.clickonSignInButton();
				aup.clickOnProceedCheckout();
				aup.clickOnAcceptCheckBox();
				aup.clickOnProcess_ProceedCheckout();
				aup.clickOnPayBankWire();
				aup.clickOnIconfirm();
				logger.info("Getting Sucess message as "+aup.getSucessMessage());
				Assert.assertEquals(true, aup.getSucessMessage().equals(Practicepojo.getUisucessMessage()));

				test.log(Status.PASS, "Validated Sucess message "+Practicepojo.getUisucessMessage());

				logger.info("Finish Testcase ==>AuthenticationFlow");
			} catch (Exception e) {
				throw new Exception("Error occured in AuthenticationFlow" + e.getMessage());
			}

	}

}
