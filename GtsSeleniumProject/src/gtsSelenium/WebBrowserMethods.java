package gtsSelenium;

public class WebBrowserMethods extends WebBrowserMethodBase
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		
		Thread.sleep(6000);
		
		driver.navigate().forward();
		
		Thread.sleep(6000);
		
		driver.navigate().refresh();
		
		//driver.close();
		
		driver.quit();
		
	}

}
