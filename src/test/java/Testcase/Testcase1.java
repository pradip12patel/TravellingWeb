package Testcase;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import PageObjectModel.TravellingPageObject;
import Resourses.BaseClass;
import Resourses.CommonMethod;
import Resourses.ConsantMethod;
import org.apache.logging.log4j.*;

public class Testcase1 extends BaseClass{
	
	@Test
	public void verify() throws AWTException   {
		
		Logger log=LogManager.getLogger(Testcase1.class);
		
		TravellingPageObject obj=new TravellingPageObject(d);
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		obj.clears().click();
		log.info("successfully click");
	    WebElement w=obj.clickcancel();
		
		CommonMethod.action(w,d);
		log.info("cleare successfully");
		obj.clears().sendKeys(ConsantMethod.city);
		log.info("put city successfully");
		CommonMethod.loop(obj.clears());
		log.info("click city successfully");
		
		obj.putcity().sendKeys(ConsantMethod.city1);
		log.info("put city1 successfully");
		CommonMethod.loop(obj.putcity());
		log.info("click city1 successfully");
		
		WebElement w1=obj.selectdate();
		CommonMethod.action(w1, d);
		
		String month="";
		while(!(month.equals("November")))     {
			
			obj.clicknext().click();
			WebElement w2=obj.pickmonth();
			month=w2.getText();
		}
		
		List<WebElement> w3=d.findElements(By.xpath("((//div//div)[88]//div[3])[3]//div"));
		
		for(WebElement total:w3)  {
			
			String dates=total.getText();
			
			if(dates.equals("15"));
			 total.click();
			 break;
		}
		
		
		
		
		
		
		
	}

  }
