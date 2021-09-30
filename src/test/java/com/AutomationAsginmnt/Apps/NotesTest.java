package com.AutomationAsginmnt.Apps;

import org.testng.annotations.Test;

import com.AutomationAsignment.utility.DefaultDriverManager;
import com.AutomationAsignment.utility.TestClassUtil;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author Biswa
 *
 */
public class AutomationPracticeTest extends TestClassUtil {
	static RemoteWebDriver driver;

	static AutomationPracticePOJO Practicepojo;

	@BeforeTest
	public void launchApp() throws Exception {
		driver = new DefaultDriverManager().getDriver();
		Practicepojo = new AutomationPracticePOJO();
		new PracticeController().launchApplication(driver);
	}

	@Test
	public void testAutomationPracticeTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		new PracticeController().ProductListingFlow(driver, test);
		new PracticeController().ProductDetailsFlow(driver, Practicepojo, test);
		new PracticeController().AuthenticationFlow(driver, Practicepojo, test);
		;
	}

	@AfterTest
	public void teardown() {
		 driver.quit();
	}

}
