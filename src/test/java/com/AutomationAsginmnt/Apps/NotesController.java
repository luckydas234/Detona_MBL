package com.AutomationAsginmnt.Apps;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.AutomationAsignment.utility.ConfigReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class NotesController {
	static Logger logger = Logger.getLogger(NotesController.class);
	NotesPOJO notespojo = new NotesPOJO();

	NotesController() {
		notespojo.setUiTitle(ConfigReader.getProperty("UI.properties", "TITLE"));
		notespojo.setUiBody(ConfigReader.getProperty("UI.properties", "BODY"));
		notespojo.setUiTime(ConfigReader.getProperty("UI.properties", "TIME"));
		notespojo.setUiExpResults(ConfigReader.getProperty("UI.properties", "EXPREASULTS"));
	}

	public void AddTextNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>Add TextNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			Assert.assertEquals(true, lp.getEmptylist(driver));

			test.log(Status.PASS, "No existingnotes present");
			lp.clickonAddButton(driver);
			test.log(Status.INFO, "Clicked on Add Button");
			lp.clickonAddNoteButton();
			test.log(Status.INFO, "Clicked on AddNotes Button");
			lp.enterTitle(notespojo.getUiTitle());
			lp.enterBody(notespojo.getUiBody());
			lp.clickonBackButton();
			Assert.assertEquals(true, lp.getNoteContent());

			test.log(Status.PASS, "Notes added Sucessfully");
			logger.info("Finish Testcase ==>Add TextNotesFlow ");
		} catch (Exception e) {
			throw new Exception("Error occured in Add TextNotesFlow" + e.getMessage());
		}

	}

	public void EditTextNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>Edit TextNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			notespojo.setUiTitle("Edit_Title");
			lp.clickonNoteContent();
			test.log(Status.INFO, "Clicked on existing note");
			lp.enterTitle(notespojo.getUiTitle());
			lp.enterBody(notespojo.getUiBody());
			lp.clickonBackButton();
			Assert.assertEquals(true, lp.getNoteContent());

			test.log(Status.PASS, "Notes Edited Sucessfully");
			logger.info("Finish Testcase ==>EditTextNotesFlow ");
		} catch (Exception e) {
			throw new Exception("Error occured in EditTextNotesFlow" + e.getMessage());
		}

	}

	public void EditTextNotesWithRenderFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>EditTextNotesWithRenderFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			notespojo.setUiTitle("Edit__Reminder_Title");
			lp.clickonNoteContent();
			test.log(Status.INFO, "Clicked on existing note");
			lp.enterTitle(notespojo.getUiTitle());
			lp.enterBody(notespojo.getUiBody());
			lp.setReminderTest(notespojo.getUiTime());
			lp.clickonBackButton();
			Assert.assertEquals(true, lp.getNoteContent());

			test.log(Status.PASS, "Notes Edited With Reminder Sucessfully");
			logger.info("Finish Testcase ==>EditTextNotesWithRenderFlow ");
		} catch (Exception e) {
			throw new Exception("Error occured in EditTextNotesWithRenderFlow" + e.getMessage());
		}

	}

	public void DeleteReminderFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>DeleteReminderFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			lp.clickonNoteContent();
			test.log(Status.INFO, "Clicked on existing note");
			lp.clickOnMoreOptions();
			lp.clickOnTrash();
			Assert.assertEquals(true, lp.getEmptylist(driver));
			test.log(Status.PASS, "Notes Deleted Sucessfully");
			logger.info("Finish Testcase ==>DeleteReminderFlow ");
		} catch (Exception e) {
			throw new Exception("Error occured in DeleteReminderFlow" + e.getMessage());
		}

	}

	public void AddImageNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>AddImageNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			notespojo.setUiTitle("Image Notes");
			Assert.assertEquals(true, lp.getEmptylist(driver));

			test.log(Status.PASS, "No existingnotes present");
			lp.clickonAddButton(driver);
			test.log(Status.INFO, "Clicked on Add Button");
			lp.clickonAddImageNoteButton();
			test.log(Status.INFO, "Clicked on Add Image Notes Button");
			lp.clickOnImage();
			test.log(Status.INFO, "Clicked on Image  Button");
			lp.enterTitle(notespojo.getUiTitle());
			lp.enterBody(notespojo.getUiBody());
			lp.clickonBackButton();
			Assert.assertEquals(true, lp.getNoteContent());

			test.log(Status.PASS, "Images added Sucessfully");
			logger.info("Finish Testcase ==>AddImageNotesFlow ");
		} catch (Exception e) {
			throw new Exception("Error occured in AddImageNotesFlow" + e.getMessage());
		}

	}

	public void EditImageReminderNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>EditImageReminderNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			notespojo.setUiTitle("Edit_Image Notes");
			lp.clickonNoteContent();
			test.log(Status.INFO, "Clicked on existing note");
			lp.enterTitle(notespojo.getUiTitle());
			lp.enterBody(notespojo.getUiBody());
			lp.setReminderTest(notespojo.getUiTime());
			lp.clickonBackButton();
			Assert.assertEquals(true, lp.getNoteContent());

			test.log(Status.PASS, "Images Note  edited Sucessfully");
			logger.info("Finish Testcase ==>EditImageReminderNotesFlow ");
		} catch (Exception e) {
			throw new Exception("Error occured in EditImageReminderNotesFlow" + e.getMessage());
		}

	}

	public void DeleteImageNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>DeleteImageNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			lp.clickonNoteContent();
			test.log(Status.INFO, "Clicked on existing note");
			lp.clickOnMoreOptions();
			lp.clickOnTrash();
			Assert.assertEquals(true, lp.getEmptylist(driver));
			test.log(Status.PASS, "Images Note  deleted Sucessfully");
			logger.info("Finish Testcase ==>DeleteImageNotesFlow ");
		} catch (Exception e) {
			throw new Exception("Error occured in DeleteImageNotesFlow" + e.getMessage());
		}

	}

	public void AddCheckListNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>AddCheckListNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			notespojo.setUiTitle("Checklist Notes");
			Assert.assertEquals(true, lp.getEmptylist(driver));

			test.log(Status.PASS, "No existingnotes present");
			lp.clickonAddButton(driver);
			test.log(Status.INFO, "Clicked on Add Button");
			lp.clickonAddCheckNoteButton();
			test.log(Status.INFO, "Clicked on AddCheckList Notes Button");
			lp.enterTitle(notespojo.getUiTitle());
			lp.enterCheckListNoteBody(notespojo.getUiBody());
			lp.clickonBackButton();
			Assert.assertEquals(true, lp.getNoteContent());

			test.log(Status.PASS, "Check list Notes added Sucessfully");
			logger.info("Finish Testcase ==>AddCheckListNotesFlow");
		} catch (Exception e) {
			throw new Exception("Error occured in AddCheckListNotesFlow" + e.getMessage());
		}

	}

	public void EditCheckListReminderNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>AddCheckListNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			notespojo.setUiTitle("Checklist Edit Notes");
			lp.clickonNoteContent();
			test.log(Status.INFO, "Clicked on existing note");
			lp.enterTitle(notespojo.getUiTitle());
			lp.enterCheckListNoteBody(notespojo.getUiBody());
			lp.setReminderTest(notespojo.getUiTime());
			lp.clickonBackButton();
			Assert.assertEquals(true, lp.getNoteContent());
			test.log(Status.PASS, "Check list Notes Edited Sucessfully");
			logger.info("Finish Testcase ==>EditCheckListReminderNotesFlow");
		} catch (Exception e) {
			throw new Exception("Error occured in EditCheckListReminderNotesFlow" + e.getMessage());
		}

	}

	public void DeleteCheckListReminderNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>DeleteCheckListReminderNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			lp.clickonNoteContent();
			test.log(Status.INFO, "Clicked on existing note");
			lp.clickOnMoreOptions();
			lp.clickOnTrash();
			Assert.assertEquals(true, lp.getEmptylist(driver));
			test.log(Status.PASS, "Checklist Note  deleted Sucessfully");
			logger.info("Finish Testcase ==>DeleteCheckListReminderNotesFlow");
		} catch (Exception e) {
			throw new Exception("Error occured in DeleteCheckListReminderNotesFlow" + e.getMessage());
		}

	}

	public void ReducedViewNotesFlow(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>DeleteCheckListReminderNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			AddTextNotesFlow(driver, test);
			lp.clickOnMoreOptions();
			test.log(Status.INFO, "Title is " + lp.get_title());
			notespojo.setUiTitle(lp.get_title());
			lp.clickOntitle();
			test.log(Status.INFO, "Title is " + lp.get_title());
			Assert.assertEquals(false, notespojo.getUiTitle().equals(lp.get_title()));
			test.log(Status.PASS, "Reduced view status validated Sucessfully");

		} catch (Exception e) {
			throw new Exception("Error occured in ReducedViewNotesFlow" + e.getMessage());
		}

	}

	public void ShareNotesFlowTest(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>ShareNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);

			lp.clickonNoteContent();
			lp.clickonShareButton();
			lp.getShareTitle();
			test.log(Status.INFO, "Title is " + lp.get_title());
			notespojo.setUiTitle(lp.get_title());
			lp.clickOntitle();
			test.log(Status.INFO, "Title is " + lp.get_title());
			Assert.assertEquals(true, lp.getShareTitle().equalsIgnoreCase(notespojo.getUiTitle()));
			test.log(Status.PASS, "ShareNotesFlowTest validated Sucessfully");
			lp.clickOnCancelButton();
			lp.clickonBackButton();
		} catch (Exception e) {
			throw new Exception("Error occured in ShareNotesFlowTest" + e.getMessage());
		}

	}

	public void TagNotesFlowTest(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>TagNotesFlow");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			lp.clickonNoteContent();
			lp.clickonTagButton();
			System.out.println(lp.TagsMessage());
			Assert.assertEquals(false, lp.TagsMessage().contains("NO TAGS"));
			test.log(Status.PASS, "TagNotesFlow validated Sucessfully");
			lp.clickonBackButton();
		} catch (Exception e) {
			throw new Exception("Error occured in TagNotesFlow" + e.getMessage());
		}

	}

	public void SettingsFlowTest(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			logger.info("Start Testcase ==>SettingsFlowTest");
			test.log(Status.INFO, "In Landing Page");
			LandingPage lp = new LandingPage(driver);
			SettingsPage sp = new SettingsPage(driver);
			lp.clickOnHumbergerMenu();
			lp.clickOnSettingsMenu();
			sp.clickOnLabel("Data");
			sp.clickOnLabel("Erase all data");
			sp.clickOnConfirmMenu();
			Assert.assertEquals(true, lp.getEmptylist(driver));
			test.log(Status.PASS, "No existing notes present");
			lp.clickonBackButton();

		} catch (Exception e) {
			throw new Exception("Error occured in SettingsFlowTest" + e.getMessage());
		}

	}

	public void TapToCrashFlowTest(RemoteWebDriver driver, ExtentTest test) throws Exception {
		try {
			try {
				logger.info("Start Testcase ==>TapToCrashFlowTest");
				test.log(Status.INFO, "In Landing Page");
				LandingPage lp = new LandingPage(driver);
				lp.clickOnHumbergerMenu();
				lp.clickOnTapToCrashMenu();
				Assert.assertEquals(true, lp.getEmptylist(driver));
			} catch (Exception e) {
				test.log(Status.PASS, "App Crashed sucessfully");
			}

		} catch (Exception e) {
			throw new Exception("Error occured in SettingsFlowTest" + e.getMessage());
		}

	}

	

}
