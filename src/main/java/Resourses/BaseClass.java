package Resourses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver d;
	public Properties p;
	
	     public void initilizedriver() throws IOException  {
	
	  FileInputStream file=new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\Resourses\\data.properties");
	
	       
	   p=new Properties();
	  
	  p.load(file);
	  
	 String key1= p.getProperty("browser");
	  
	  if(key1.equalsIgnoreCase("chrome"))  {
		  
		  ChromeOptions op=new ChromeOptions();
		  
		  op.addArguments("--remote-allow-origins=*");
		  
		   d=new ChromeDriver(op);
	  }  
		   else if(key1.equalsIgnoreCase("firefox"))  {
			    
			   d=new FirefoxDriver();
	
	  }
		   else {
			   
			   System.out.println("plz check the name");
		   }
	  
	     } 
	     
	     @BeforeSuite
	     public void setups()   {
	    	 
	    	 Extendmanager.setup();
	     }
	     
	    
	    @BeforeMethod
	  public void openurl() throws IOException    {
		  
		  initilizedriver();
		  
		 String key2= p.getProperty("URL");
		 
		 d.get(key2); 
		  
	  }
	  
	    @AfterSuite
	   public void aftersuite()  {
		   
		   Extendmanager.endreport();
	   }

      
	    @AfterMethod
       public void teardown(ITestResult result)  {
    	   
    	   d.manage().window().maximize();
       }

         public static String getscreenshot(WebDriver d, String screenshotname) throws IOException   {
        	 
        String dateformate=new SimpleDateFormat("yyyy-MM-dd/hhmmss").format(new Date());
        
        TakesScreenshot ts=(TakesScreenshot) d;
        
        File source=ts.getScreenshotAs(OutputType.FILE);
        
        String destination = System.getProperty("user.dir") + "/Faildtestcase/" + screenshotname + dateformate + ".png";
        	 
        	 
        File finaldestination=new File(destination);
        
        FileUtils.copyFile(source, finaldestination);
        
			return destination;
        	 
         }
         
         
         public static String getcurrentdate()     {
        	 
        	 String currentdateformate=new SimpleDateFormat("yyyy-MM-dd/hhmmss").format(new Date()); 
        	 
        	 
			return currentdateformate;
        	 
        	 
        	 
        	 
         }

    }







