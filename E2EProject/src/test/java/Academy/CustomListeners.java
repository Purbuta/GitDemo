package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//ITestListener is interface which implement testng listeners

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class CustomListeners extends Base implements ITestListener {
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//This is a Thread pool(Thread safe) which is being used for parallel execution
	//In multiple testcases parralel execution, in ThreadLoacl we set the test and whenever required we get it.
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//For creating report
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I successfully executed the listeners....." +result.getName());
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		//screenshot
		System.out.println("inside onTestFailure===");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver), testMethodName);//Take the screenshot from the folder and paste it in the Report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//getScreenshotPath(testMethodName,driver);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	
  
}
