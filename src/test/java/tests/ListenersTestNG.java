package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseSetup;
import utility.ExtentReporterNG;

public class ListenersTestNG extends BaseSetup implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReport();

	public void onTestStart(ITestResult result) {
		// System.out.println(result.getName() + ": testcase started");
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// System.out.println("The name of the testcase passed is:" + result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// System.out.println("TestCase Failed is:" + result.getName());
		test.fail(result.getThrowable());
		WebDriver driver = null;

		String methodName = result.getMethod().getMethodName(); // automatically captures failed testcase name
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			getScreenshot(methodName, driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is:" + result.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
