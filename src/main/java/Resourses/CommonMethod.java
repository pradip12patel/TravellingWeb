package Resourses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonMethod {
	
	static WebDriver d;
	
	public static void action(WebElement e, WebDriver de)   {
		
		Actions a=new Actions(de);
		
		a.moveToElement(e).click().perform();
		
	}
	
	  public static void loop(WebElement a)   {
		  
		  for(int i=0;i<=0;i++)  {
				
				a.sendKeys(Keys.ARROW_DOWN);
			}
			a.sendKeys(Keys.ENTER);
		  
	  }

}
