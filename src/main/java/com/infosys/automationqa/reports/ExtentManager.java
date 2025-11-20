package com.infosys.automationqa.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test method
	public void onStart(ITestContext context) {
	   sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/ExtentReport.html");
		
	   sparkReporter.config().setDocumentTitle("Automation Report");
	   sparkReporter.config().setReportName("Functional Testing");
	   sparkReporter.config().setTheme(Theme.DARK);
	   
	   extent= new ExtentReports();
	   extent.attachReporter(sparkReporter);
	   extent.setSystemInfo("Environment", "QA");
       extent.setSystemInfo("Tester", "Aditya Anand");
	  }
 
    public void onTestSuccess(ITestResult result) {
    	test=extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.PASS, "Test case Passed is:"+ result.getName()); //update status pass fail
     
    }

   
    public void onTestFailure(ITestResult result) {
    	test=extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.FAIL, "Test case Failed is:"+ result.getName()); //update status pass fail
     
        
    }

 
    public void onTestSkipped(ITestResult result) {
    	test=extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.SKIP, "Test case Skipped is:"+ result.getName()); //update status pass fail
     
      
    }


    public void onFinish(ITestContext context) //mandatory method then it will write in the report
    {  
    	extent.flush();
        
    }
}
