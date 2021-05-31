package gtsSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class WebBrowserProfile 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;

	public static void init() throws Exception 
	{
		fis = new FileInputStream(projectPath+"//data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"//environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"//"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String var = childProp.getProperty("icici");
		System.out.println(var);
	}
	
	
	public static void launch(String browser)
	{
		if (p.getProperty(browser).equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\reddy\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			option.addArguments("--disable-notificatins");
			
			driver = new ChromeDriver(option);
			
		}
		else if (p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			
			ProfilesIni P = new ProfilesIni();
			FirefoxProfile profile = P.getProfile("myffprofile");
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			
			driver = new FirefoxDriver(option);
		}
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(p.getProperty(url));
	}

}
