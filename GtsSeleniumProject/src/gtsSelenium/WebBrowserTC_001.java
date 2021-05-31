package gtsSelenium;

public class WebBrowserTC_001 extends WebBrowserBaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("ebayurl");
	}

}
