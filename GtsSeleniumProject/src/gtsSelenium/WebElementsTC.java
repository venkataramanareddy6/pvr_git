package gtsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementsTC extends WebElementsBaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("firefoxbrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazondropbox_id","Books");
		
		typeText("amazonsearchtext_id","selenium");
		
		clickElement("amazonsearchbutton_xpath");
		
//		WebElement loc = driver.findElement(By.id("searchDropdownBox"));
//		loc.sendKeys("Books");
//		
//		driver.findElement(By.name("field-keywords")).sendKeys("selenium");
//		
//		driver.findElement(By.xpath("//*[@id='gh-ac']")).click();
	}

	

}
