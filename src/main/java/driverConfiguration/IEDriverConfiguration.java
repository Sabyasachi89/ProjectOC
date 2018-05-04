package driverConfiguration;

import org.apache.http.cookie.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverConfiguration {
	
	static WebDriver driver;
	
	public IEDriverConfiguration() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.ie.driver", "C:\\Users\\sdeb\\eclipse-workspace\\IAP Automation\\IEDriverServer.exe");
		
		DesiredCapabilities ieCapabilities = new DesiredCapabilities();
		
		ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		
		driver = new InternetExplorerDriver(ieCapabilities);

	}
	
	public static WebDriver getDriver() {

		return driver;
	}
	
	/*private static IEDriverConfiguration ieDriverConfiguration = new IEDriverConfiguration();
	
	public WebDriver returnDriver() {
		
		DesiredCapabilities ieCapabilities = new DesiredCapabilities();
		
		ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		
		driver = new InternetExplorerDriver(ieCapabilities);
		return driver;
	}
	
	public IEDriverConfiguration getInstance() {
		//returnDriver();
		return ieDriverConfiguration;
	}*/
	
	/*public static WebDriver getDriver() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdeb\\eclipse-workspace\\IAP Automation\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			DesiredCapabilities ieCapabilities = new DesiredCapabilities();
			
			ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);			
			
			@SuppressWarnings("deprecation")
			InternetExplorerDriver driver = new InternetExplorerDriver(ieCapabilities);
			
			InternetExplorerDriver driver = new InternetExplorerDriver(ieCapabilities);
			
			return driver;
		}*/
	

}
