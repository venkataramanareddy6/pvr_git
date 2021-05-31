package gtsSelenium;

public class WebBrowserProfileTC extends WebBrowserProfile
{

	public static void main(String[] args) throws Exception
	{
		init();
		
		launch("firefoxbrowser");
		
		navigateUrl("iciciurl");
	}

}
