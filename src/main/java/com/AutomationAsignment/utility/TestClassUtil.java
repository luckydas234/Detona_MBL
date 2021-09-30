package com.AutomationAsignment.utility;

import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;

public class TestClassUtil {

	static Logger logger = Logger.getLogger(TestClassUtil.class);
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void setup() {
		BasicConfigurator.configure();
		String path = System.getProperty("user.dir") + "//"
				+ ConfigReader.getProperty("Config.properties", "REPORT_PATH");
		htmlReporter = new ExtentHtmlReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "WINDOWS 10");
		extent.setSystemInfo("Host Name", "Biswaranjan");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Biswaranjan");
		htmlReporter.config().setReportName("NOTES -Automation Execution Report");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("NOTES APP Execution Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterMethod
	public void getResult(ITestResult result, RemoteWebDriver driver) throws IOException {
		logger.info("---report Updated For tESTCASE---");

		System.out.println(result.getStatus() + "RESULT");
		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));

			test.fail(result.getThrowable());
			

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			
			test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case PASSED", ExtentColor.GREEN));
	} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case SKIPPED", ExtentColor.BLUE));
			test.skip(result.getThrowable());
		}

		extent.flush();
	}
}
