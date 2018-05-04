package driverConfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginApplication {
	
	WebDriver driver;

	public LoginApplication(WebDriver driver) {
		
		this.driver = driver;
		
		driver.manage().window().maximize();
		//driver.get("https://iox-pctr-bpm:9443/ProcessPortal/dashboards/SYSRP/RESPONSIVE_WORK");
		
		driver.get("https://iox-psvr-bpm:9443/ProcessPortal/launchTaskCompletion?taskId=3715");
		
		//https://iox-psvr-bpm:9443/ProcessPortal/dashboards/SYSRP/RESPONSIVE_WORK
		//driver.navigate().to("javascript:document.getElementById(‘overridelink’).click()");
		
		/*driver.findElement(By.linkText("More information")).click();;
		
		driver.findElement(By.id("overridelink")).click();*/
		
		driver.findElement(By.linkText("More information")).click();;
		
		driver.findElement(By.id("overridelink")).click();
		
		driver.findElement(By.id("username")).sendKeys("sabyasachi");
		
		driver.findElement(By.id("password")).sendKeys("test123");
		
		driver.findElement(By.id("signInForm")).findElement(By.tagName("a")).click();
	}
}
