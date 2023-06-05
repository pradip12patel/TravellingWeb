package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Resourses.BaseClass;
import Resourses.Extendmanager;

public class ListenerClass extends Extendmanager implements ITestListener{
	
	
	    
	
	    public void onTestStart(ITestResult result) {
	    	
	    	test=report.createTest(result.getName());
	    	
	    }
	    
	    
	    
	    public void onTestFailure(ITestResult result) {
	 
	    if(result.getStatus() == ITestResult.FAILURE)   {
	    	
	    	test.log(Status.FAIL, "test case failed is: " + result.getName());
	    	test.log(Status.FAIL, "test case failed is: " + result.getThrowable());
	    	
	    	String screenshotpath = "";
	    	
	    	try {
	    		
	    		screenshotpath = BaseClass.getscreenshot(BaseClass.d, result.getName());
	    		
	    		test.addScreenCaptureFromPath(screenshotpath);
	    	}
	    	catch(Exception e)   {
	    		
	    		e.printStackTrace();
	    	}
	    	
	    }	
	        }
	    
	    
	    
	   
	public void onTestSuccess(ITestResult result) {
	
		if(result.getStatus() == ITestResult.SUCCESS)  {
			
			test.log(Status.PASS, "tet case is passed: " + result.getName());
		}
		
		
	}
	   
	
	
	public void onTestSkipped(ITestResult result) {
     
		if(result.getStatus() == ITestResult.SKIP)   {
			
			test.log(Status.SKIP, "Test case is skipped: "+ result.getName());
		}
		
	}
	
	
	

}
