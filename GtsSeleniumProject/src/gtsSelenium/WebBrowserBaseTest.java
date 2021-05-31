package gtsSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBrowserBaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties p;
	
	public static void init() throws Exception
	{
		FileInputStream f = new FileInputStream(projectPath +"//data.properties");
		p = new Properties();
		p.load(f);
	}
	
	public static void launch(String browser)
	{
		if (p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver.manage().window().maximize();
			driver = new ChromeDriver();
			
		}
		else if (p.getProperty(browser).equals("firefor"))
		{
			System.setProperty("webdriver.gecko.driver", "‪D:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(p.getProperty(url));
	}

}
