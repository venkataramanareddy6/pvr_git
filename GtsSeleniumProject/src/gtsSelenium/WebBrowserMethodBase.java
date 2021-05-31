package gtsSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowserMethodBase
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream f;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;

	public static void init() throws Exception 
	{
		f = new FileInputStream(projectPath +"//data.properties");
		p = new Properties();
		p.load(f);
		
		f = new FileInputStream(projectPath +"//environment.properties");
		mainProp = new Properties();
		mainProp.load(f);
		String e= mainProp.getProperty("env");
		System.out.println(e);
		
		f = new FileInputStream(projectPath +"//"+e+".properties");
		childProp = new Properties();
		childProp.load(f);
		String var = childProp.getProperty("amazonurl");
		System.out.println(var);
	}
	
	public static void launch(String browser)
	{
		if (p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", projectPath +"//driver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	}
	public static void navigateUrl(String url)
	{
		driver.navigate().to(childProp.getProperty(url));
	}

}
