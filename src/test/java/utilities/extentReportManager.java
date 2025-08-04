package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentReportManager implements ITestListener {
	
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	//so that any method in this class has the same driver with the test case file's driver that using setWebDriver
	public static void setWebDriver(WebDriver dr)
	{
		driver=dr;
	}
	
	public void onStart(ITestContext context) {
	    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
	    repName = "Test report"+"_"+timeStamp+".html";
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\"+repName);
	    sparkReporter.config().setDocumentTitle("Automation Report");
	    sparkReporter.config().setReportName("Functional Testing");
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    
	    extent.setSystemInfo("Application", "Parabank");
	    extent.setSystemInfo("Environment", "Staging");
	    extent.setSystemInfo("User", System.getProperty("user.name"));
	    
	    String operatingSystem = context.getCurrentXmlTest().getParameter("os");
	    extent.setSystemInfo("os", operatingSystem);
	    
	    String browser = context.getCurrentXmlTest().getParameter("browser");
	    extent.setSystemInfo("browser", browser);
	    
	    List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
	    extent.setSystemInfo("groups", groups.toString());	
	}
	
	public void onTestSuccess(ITestResult result) {
	    test = extent.createTest(result.getTestClass().getName()); //create new entry in report
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.PASS, "Test case PASSED is "+result.getName());
	  }

	public void onTestFailure(ITestResult result) {
	    test = extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.FAIL, "Test case FAILED is "+result.getName());
	    test.log(Status.FAIL, "Test case is Failed due to "+result.getThrowable().getMessage());
	  
	    screenshot ss = new screenshot(driver);
	    String imgPath = ss.capturedScreen(result.getName());
	    test.addScreenCaptureFromPath(imgPath);
	  }
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case SKIPPED is "+result.getName());
		test.log(Status.SKIP, "Test case is Skipped due to "+result.getThrowable().getMessage());	
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  //if you want to automatically open the report once the test finished
	  		// Build path to the report file
	  	    String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
	  	    File extentReport = new File(pathOfExtentReport);

	  	    // Wait until the file is created (with timeout)
	  	    int waitTimeInMillis = 3000; // Max 3 seconds
	  	    int interval = 100;
	  	    int waited = 0;

	  	    while (!extentReport.exists() && waited < waitTimeInMillis) {
	  	        try {
	  	            Thread.sleep(interval);
	  	            waited += interval;
	  	        } catch (InterruptedException e) {
	  	            e.printStackTrace();
	  	        }
	  	    }

	  	    // Try to open it after it's created
	  	    if (extentReport.exists()) {
	  	        try {
	  	            Desktop.getDesktop().browse(extentReport.toURI());
	  	        } catch (IOException e) {
	  	            e.printStackTrace();
	  	        }
	  	    } else {
	  	        System.err.println("Extent report file not found after waiting.");
	  	    }
	  }
}
