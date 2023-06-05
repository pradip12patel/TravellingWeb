package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravellingPageObject {
	
	WebDriver d;
	
	By clear =By.xpath("//input[@id='originInput-input']");
	By cancel=By.xpath("//*[name()='path' and contains(@d,'M12 2a10 1')]");
	By city=By.xpath("//input[@id='destinationInput-input']");
	By date=By.xpath("//button[@data-testid='depart-btn']//span[@class='BpkText_bpk-text__OTg0N BpkText_bpk-text--body-default__N2U4M SearchControlButton_placeholder__MThkM'][normalize-space()='Add date']");
	By next=By.xpath("//*[name()='path' and contains(@d,'M7.8 4.287')]");
	By month=By.xpath("//h2[normalize-space()='November']");
	
	public TravellingPageObject(WebDriver d2) {
		
		this.d=d2;
	}


	public WebElement clears()  {
		
	return	d.findElement(clear);
		
	}
	
	
    public WebElement clickcancel()  {
		
	return	d.findElement(cancel);
		
	}
	
    public WebElement putcity()  {
		
    	return	d.findElement(city);
    		
    	}
	
    public WebElement selectdate()  {
		
    	return	d.findElement(date);
    		
    	}
	
     public WebElement clicknext()  {
		
    	return	d.findElement(next);
    		
    	}
     
     
     public WebElement pickmonth()  {
 		
     	return	d.findElement(month);
     		
     	}
     
     
     
     
     
     
     
     
}
