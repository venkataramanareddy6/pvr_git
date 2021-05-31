package gtsSelenium;

public class WebBrowserTC_002 extends WebBrowserBaseTest
{

	public static void main(String[] args) 
	{
		launch("chrome");
		
		navigateUrl("https:www.ebay.com");
	}

}
