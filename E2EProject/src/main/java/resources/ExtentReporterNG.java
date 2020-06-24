package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent = new ExtentReports();
	
	public static ExtentReports getReportObject()
	{
		 // ExtentReports - main class to create report,ExtentSparkReporter- create one html file and do some configuration
		  String path =  System.getProperty("user.dir")+"\\reports\\index.html";
		  ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		  reporter.config().setReportName("Web Automation Results");
		  reporter.config().setDocumentTitle("Test Results");
		  
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("Tester", "Purbita SenChoudhuri");
		  return extent;
	}

}
