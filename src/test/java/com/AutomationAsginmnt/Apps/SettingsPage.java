package com.AutomationAsginmnt.Apps;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.AutomationAsignment.utility.ActionBot;
import com.AutomationAsignment.utility.ConfigReader;

import io.appium.java_client.AppiumDriver;

public class SettingsPage {

	RemoteWebDriver driver;
	int timeOutPeriod;
	/* All WebElements are identified by @FindBy annotation */

	public SettingsPage(RemoteWebDriver driver) {

		this.driver = driver;

		timeOutPeriod = Integer.parseInt(ConfigReader.getProperty("config.properties", "TIMEOUT"));

	}

	public void clickOnLabel(String sData) throws Exception {
		Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like [NATIVE_APP, WEBVIEW_<APP_PKG_NAME>]
			((AppiumDriver) driver).context(contextName);
		}

		List<WebElement> DataLabel = driver.findElements(By.className("android.widget.TextView"));
		System.out.println(DataLabel.size());
		/*
		 * for(WebElement wb:DataLabel) { System.out.println(wb.getText());
		 * if(wb.getText().equalsIgnoreCase(sData)) {
		 * ActionBot.focusAndclick(driver,wb); break; }
		 * 
		 * 
		 * }
		 */}

	public void clickOnConfirmMenu() throws Exception {
		WebElement ConfirmMenu = driver
				.findElement(By.id("it.feio.android.omninotes.alpha:id/md_buttonDefaultPositive"));
		ActionBot.focusAndclick(driver, ConfirmMenu);

	}
}
