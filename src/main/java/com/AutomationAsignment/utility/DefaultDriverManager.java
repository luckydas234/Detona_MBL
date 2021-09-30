package com.AutomationAsignment.utility;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DefaultDriverManager {
	static Logger logger = Logger.getLogger(DefaultDriverManager.class);

	private String automatioNname = null;
	private String platformName = null;
	private String platformversion = null;
	private String deviceName = null;
	private String appium_server_URL = null;
	private String appProperties = null;
	private String appPackage = null;
	private String appActivity = null;

	private boolean configLoaded = false;

	public void loadConfig()

	{
		BasicConfigurator.configure();

		automatioNname = ConfigReader.getProperty("config.properties", "AUTOMATIONNAME");

		platformName = ConfigReader.getProperty("config.properties", "PLATFORMNAME");

		platformversion = ConfigReader.getProperty("config.properties", "PLATFORMVERSION");

		deviceName = ConfigReader.getProperty("config.properties", "DEVICENAME");

		appium_server_URL = ConfigReader.getProperty("config.properties", "APPIUM_SERVER_URL");

		appProperties = ConfigReader.getProperty("config.properties", "APP");

		appPackage = ConfigReader.getProperty("config.properties", "APP_PACKAGE");

		appActivity = ConfigReader.getProperty("config.properties", "APP_ACTIVITY");

		configLoaded = true;

	}

	public AppiumDriver getMobileDriver() throws Exception {
		try {

			if (!configLoaded) {
				loadConfig();
			}

			AppiumDriver driver = null;

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("noReset", "False");
			cap.setCapability("fullReset", "False");
			cap.setCapability("automatioNname", automatioNname);
			cap.setCapability("platformName", platformName);
			cap.setCapability("platformversion", platformversion);
			cap.setCapability("udid", deviceName);
			cap.setCapability("newCommandTimeout", 10000);
			cap.setCapability("app", appProperties);
			cap.setCapability("apppackage", appPackage);
			cap.setCapability("appactivity", appActivity);

			String appiumServerUrl = System.getProperty("APPIUM_SERVER_URL");
			if (appiumServerUrl == null) {
				appiumServerUrl = appium_server_URL;
			}

			driver = new AndroidDriver(new URL(appiumServerUrl), cap);

			driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);

			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Exception occured in getMobileDriver");
		}
	}

}
