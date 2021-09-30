package com.AutomationAsginmnt.Apps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationAsignment.utility.ActionBot;
import com.AutomationAsignment.utility.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class LandingPage {

	RemoteWebDriver driver;
	int timeOutPeriod;
	/* All WebElements are identified by @FindBy annotation */

	public LandingPage(RemoteWebDriver driver) {

		this.driver = driver;

		// This initElements method will initialize all webelements

		timeOutPeriod = Integer.parseInt(ConfigReader.getProperty("config.properties", "TIMEOUT"));

	}

	public boolean getEmptylist(RemoteWebDriver driver) throws Exception {
		WebElement Empty_List = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/empty_list"));
		return ActionBot.waitForElementToBeDisplayed(driver, Empty_List, 10).isDisplayed();
	}

	public void clickonAddButton(RemoteWebDriver driver) throws Exception {
		WebElement Add_Btn = driver
				.findElement(MobileBy.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
		ActionBot.focusAndclick(driver, Add_Btn);

	}

	public void clickonAddNoteButton() throws Exception {
		WebElement Add_Note_Btn = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
		ActionBot.focusAndclick(driver, Add_Note_Btn);

	}

	public void enterTitle(String sTitle) throws Exception {
		WebElement Content_Title = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
		ActionBot.enter_Text(driver, Content_Title, sTitle);

	}

	public void enterBody(String sBody) throws Exception {
		WebElement Content_Body = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/detail_content"));
		ActionBot.enter_Text(driver, Content_Body, sBody);

	}

	public void clickonBackButton() throws Exception {
		WebElement Back_Button = driver
				.findElement(By.xpath("//android.widget.ImageButton[@content-desc='drawer open']"));
		ActionBot.focusAndclick(driver, Back_Button);

	}

	public boolean getNoteContent() throws Exception {
		WebElement NoteContent = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_content"));

		return ActionBot.waitForElementToBeDisplayed(driver, NoteContent, 10).isDisplayed();

	}

	public void clickonNoteContent() throws Exception {
		WebElement NoteContent = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_content"));

		ActionBot.focusAndclick(driver, NoteContent);

	}

	public void setReminderTest(String sTime) throws Exception {
		WebElement NoteDateTime = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/datetime"));

		ActionBot.focusAndclick(driver, NoteDateTime);

		WebElement Time = driver.findElement(By.xpath(
				"//com.appeaser.sublimepickerlibrary.timepicker.RadialTimePickerView.RadialPickerTouchHelper[@content-desc="
						+ sTime + "]"));

		ActionBot.focusAndclick(driver, Time);

		WebElement OKButton = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/buttonPositive"));

		ActionBot.focusAndclick(driver, OKButton);

	}

	public void clickOnMoreOptions() throws Exception {
		WebElement MoreOptions = driver
				.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
		ActionBot.focusAndclick(driver, MoreOptions);

	}

	public void clickOnTrash() throws Exception {
		WebElement Trash = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]"));
		ActionBot.focusAndclick(driver, Trash);

	}

	public void clickonAddImageNoteButton() throws Exception {
		WebElement Add_Image_Note_Btn = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/fab_camera"));
		ActionBot.focusAndclick(driver, Add_Image_Note_Btn);

	}

	public void clickOnImage() throws Exception {

		// Runtime.getRuntime().exec("adb shell input `keyevent` 'KEYCODE_VOLUME_UP'");
		Thread.sleep(20000);

	}

	public void clickonAddCheckNoteButton() throws Exception {
		WebElement Add_Check_Note_Btn = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/fab_checklist"));
		ActionBot.focusAndclick(driver, Add_Check_Note_Btn);

	}

	public void enterCheckListNoteBody(String sBody) throws Exception {
		List<WebElement> ChecklistNoteBody = driver
				.findElements(By.xpath("//android.widget.LinearLayout/android.widget.EditText"));
		ActionBot.enter_Text(driver, ChecklistNoteBody.get(1), sBody);

	}

	public void clickOntitle() throws Exception {
		WebElement title = driver.findElement(By.className("android.widget.TextView"));
		ActionBot.focusAndclick(driver, title);

	}

	public String get_title() throws Exception {
		return driver.findElement(By.className("android.widget.TextView")).getText();
	}

	public void clickonShareButton() throws Exception {
		WebElement ShareButton = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/menu_share"));
		ActionBot.focusAndclick(driver, ShareButton);

	}

	public void clickonTagButton() throws Exception {
		WebElement TagsButton = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/menu_tag"));
		ActionBot.focusAndclick(driver, TagsButton);

	}

	public String getShareTitle() throws Exception {
		return driver.findElement(By.id("miui:id/alertTitle")).getText();

	}

	public void clickOnCancelButton() throws Exception {
		WebElement cancel = driver.findElement(By.id("android:id/button2"));
		ActionBot.focusAndclick(driver, cancel);

	}

	public void clickOnHumbergerMenu() throws Exception {
		WebElement HumbergerMenu = driver
				.findElement(By.xpath("//android.widget.ImageButton[@content-desc='drawer open']"));
		ActionBot.focusAndclick(driver, HumbergerMenu);

	}

	public void clickOnSettingsMenu() throws Exception {
		WebElement SettingsMenu = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/settings_view"));
		ActionBot.focusAndclick(driver, SettingsMenu);

	}

	public void clickOnTapToCrashMenu() throws Exception {
		WebElement CrashMenu = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/crash"));
		ActionBot.focusAndclick(driver, CrashMenu);

	}

	public String TagsMessage() throws Exception {
		return driver.findElement(By.id("it.feio.android.omninotes.alpha:id/toolbar")).getText();

	}

}
