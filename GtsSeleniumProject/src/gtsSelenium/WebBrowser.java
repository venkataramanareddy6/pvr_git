package gtsSelenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ebay.com");
	}

}
