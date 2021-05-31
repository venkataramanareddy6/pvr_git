package gtsSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class WebElementsBaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
			

	public static void init() throws Exception 
	{
		fis = new FileInputStream(projectPath+"//environment.properties");
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
		String var = childProp.getProperty("amazonurl");
		System.out.println(var);
		
		fis = new FileInputStream(projectPath+"//or.properties");
		orProp = new Properties();
		orProp.load(fis);
	}
	
	public static void launch(String browser)
	{
		if (p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\reddy\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
		}
		else if (p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", projectPath+"//driver//geckodriver.exe");
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("myffprofile");
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			
			driver  = new FirefoxDriver(option);
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(p.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void selectOption(String locatorkey, String option)
	{
		//driver.findElement(By.id(locator)).sendKeys(option);
		getElement(locatorkey).sendKeys(option);
		
		
	}
	

	public static void typeText(String locatorkey, String text) 
	{
		//driver.findElement(By.name(locator)).sendKeys(text);
		getElement(locatorkey).sendKeys(text);
		
	}

	public static void clickElement(String locatorkey) 
	{
		//driver.findElement(By.xpath(locator)).click();
		getElement(locatorkey).click();
	}
	
	public static WebElement getElement(String locatorkey)
	{
		WebElement element = null;
		
		if(locatorkey.endsWith("_id"))
		{
			element = driver.findElement(By.id(orProp.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_name"))
		{
			element = driver.findElement(By.name(orProp.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_classname"))
		{
			element = driver.findElement(By.className(orProp.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_xpath"))
		{
			element = driver.findElement(By.xpath(orProp.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_css"))
		{
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_linktext"))
		{
			element = driver.findElement(By.linkText(orProp.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_pariallinktext"))
		{
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorkey)));
		}
		
		return element;
	}
	


}
