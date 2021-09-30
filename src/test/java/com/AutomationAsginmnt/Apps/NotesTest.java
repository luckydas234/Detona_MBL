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
 * @Since 30-09-2021
 *
 */
public class NotesTest extends TestClassUtil {
	RemoteWebDriver driver;

	NotesPOJO Practicepojo;

	NotesController notesController;

	@BeforeTest

	public void launchApp() throws Exception {

		Practicepojo = new NotesPOJO();
		notesController = new NotesController();
		driver = new DefaultDriverManager().getMobileDriver();
	}

	@Test(priority = 1)
	public void AddTextNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.AddTextNotesFlow(driver, test);
	}

	@Test(priority = 2)
	public void EditTextNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.EditTextNotesFlow(driver, test);
	}

	@Test(priority = 3)
	public void EditTextNotesSetReminderTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.EditTextNotesWithRenderFlow(driver, test);
	}

	@Test(priority = 4)
	public void DeleteReminderTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.DeleteReminderFlow(driver, test);
	}

	@Test(priority = 5)
	public void AddImageNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.AddImageNotesFlow(driver, test);
	}

	@Test(priority = 6)
	public void EditImageNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.EditImageReminderNotesFlow(driver, test);
	}

	@Test(priority = 7)
	public void DeleteImageNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.DeleteImageNotesFlow(driver, test);
	}

	@Test(priority = 8)
	public void AddCheckListNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.AddCheckListNotesFlow(driver, test);
	}

	@Test(priority = 9)
	public void EditReminderCheckListNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.EditCheckListReminderNotesFlow(driver, test);
	}

	@Test(priority = 10)
	public void DeleteReminderCheckListNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.DeleteCheckListReminderNotesFlow(driver, test);
	}

	@Test(priority = 11)
	public void ReducedViewNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.ReducedViewNotesFlow(driver, test);
	}

	@Test(priority = 12)
	public void ShareNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.ShareNotesFlowTest(driver, test);

	}

	@Test(priority = 13)
	public void TagNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.TagNotesFlowTest(driver, test);

	}

	@Test(priority = 14)
	public void SettingsNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		notesController.SettingsFlowTest(driver, test);
		driver.quit();
	}

	@Test(priority = 15)
	public void TapToCrashNotesTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		driver = new DefaultDriverManager().getMobileDriver();
		notesController.TapToCrashFlowTest(driver, test);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
