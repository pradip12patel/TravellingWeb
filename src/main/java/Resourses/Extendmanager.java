package Resourses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extendmanager {
	
	public  static   ExtentReports report;         //Responsible for entairs
	  public static   ExtentTest test;             //Responsible for test case fail,pass or skipped
	public  static   ExtentSparkReporter htmlreport;   //Responsible for look and feel
	    
	    public static void setup()  {
	    	
	   htmlreport =new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/Extent_Report/"+"MyReport_" + BaseClass.getcurrentdate() + ".html");
	   
	   htmlreport.config().setDocumentTitle("automation result");
	   htmlreport.config().setReportName("TravellingWeb");
	   htmlreport.config().setTheme(Theme.DARK);
	   
	   report =new ExtentReports();
	   
	   report.createTest("My first result", "Ravi");
	   report.setSystemInfo("OS", "Window10");
	   report.attachReporter(htmlreport);
	   report.setSystemInfo("Ravi", "Tester");
	    	
	    }
	   
	    public static void endreport()  {
	    	
	    	report.flush();
	    }

}
