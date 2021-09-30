package com.AutomationAsginmnt.Apps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationAsignment.utility.ActionBot;
import com.AutomationAsignment.utility.ConfigReader;

public class AuthenticationPage {

	RemoteWebDriver driver;
	int timeOutPeriod;
	/* All WebElements are identified by @FindBy annotation */

	public AuthenticationPage(RemoteWebDriver driver) {

		this.driver = driver;

		// This initElements method will initialize all webelements

		PageFactory.initElements(driver, this);
		timeOutPeriod = Integer.parseInt(ConfigReader.getProperty("config.properties", "TIMEOUT"));

	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailId;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement Password;

	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	WebElement SignInButton;

	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement Proceed_toCheckOutBtn;

	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement Process_Proceed_toCheckOutBtn;

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement Accept_chkBox;

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement PayByBankWire;

	@FindBy(xpath = "//*[text()='I confirm my order']")
	WebElement IconfirmOrder;

	@FindBy(xpath = "//strong[normalize-space()='Your order on My Store is complete.']")
	WebElement sucessMessage;

	public void enterEmail(String email) throws Exception {

		ActionBot.enter_Text(driver, this.EmailId, email);

	}

	public void enterPassword(String Password) throws Exception {

		ActionBot.enter_Text(driver, this.Password, Password);

	}

	public void clickonSignInButton() throws Exception {

		ActionBot.focusAndclick(driver, SignInButton);

	}

	public void clickOnProceedCheckout() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, Proceed_toCheckOutBtn, timeOutPeriod);
		ActionBot.focusAndclick(driver, Proceed_toCheckOutBtn);

	}

	public void clickOnProcess_ProceedCheckout() throws Exception {

		ActionBot.focusAndclick(driver, Process_Proceed_toCheckOutBtn);

	}

	public void clickOnAcceptCheckBox() throws Exception {

		ActionBot.focusAndclick(driver, Accept_chkBox);

	}

	public void clickOnPayBankWire() throws Exception {
		ActionBot.waitForElementToBeDisplayed(driver, PayByBankWire, timeOutPeriod);
		ActionBot.focusAndclick(driver, PayByBankWire);

	}

	public void clickOnIconfirm() throws Exception {
		ActionBot.waitForElementToBeDisplayed(driver, IconfirmOrder, timeOutPeriod);
		ActionBot.focusAndclick(driver, IconfirmOrder);

	}

	public String getSucessMessage() throws Exception {

		ActionBot.waitForElementToBeDisplayed(driver, sucessMessage, timeOutPeriod);
		return sucessMessage.getText();
	}

}
