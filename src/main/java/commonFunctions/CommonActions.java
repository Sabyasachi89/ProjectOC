package commonFunctions;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
	
	public void enterValuesInDropdown(WebDriver driver, WebElement element, String value) {
		
		//driver.findElement((By) element).sendKeys(value);;
		
		Actions act = new Actions(driver);
		act.sendKeys(element, value).sendKeys(Keys.ENTER).build().perform();
		//act.sendKeys(Keys.TAB);
		//act.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void waitFunction(int timeInMillis) {
		
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public WebElement fluentWaitFunction(WebDriver driver, final HashMap<String, By> locator, final String key) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(600, TimeUnit.MILLISECONDS)
				.ignoring(Exception.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				
				return driver.findElement(locator.get(key));
			}

		});
		
		return element;
	}

	
	public List<WebElement> fluentWaitFunctionForListOfWebElements(WebDriver driver, final HashMap<String, By> locator, final String key) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(600, TimeUnit.MILLISECONDS)
				.ignoring(Exception.class);
		
		List<WebElement> webElements = wait.until(new Function<WebDriver, List<WebElement>>() {
			
			public List<WebElement> apply(WebDriver driver) {
				
				return driver.findElements(locator.get(key));
			}

		});
		
		System.out.println(webElements.size());
		return webElements;
	}
}
