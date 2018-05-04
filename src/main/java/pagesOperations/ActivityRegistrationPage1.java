package pagesOperations;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.CommonActions;

public class ActivityRegistrationPage1 {
	
	
	/*@FindBy(linkText = "‪Activity Registration‬")
	WebElement activityRegLink;*/
	
	@FindBy(xpath = "//div[@id='div_1_2_1_1']//a[contains(@class,'icon-hamburger')]")
	WebElement hamburgerLink;
	
	@FindBy(xpath = "//a[@title='Activity Registration']")
	WebElement activityRegLink;
	
	@FindBy(id = "dijit_form_ComboBox_0")
	WebElement activtyName;
	
	/*@FindBy(xpath="//div[@aria-owns='div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_5_1_1_2_1_widget_popup']/input")
	WebElement locationDropdown;*/
	
	/*@FindBy(id="div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_5_1_1_2_1_widget")
	WebElement locationDropdown;*/
	
	@FindBy(xpath = "//input[@id='div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_5_1_1_2_1_widget']")
	WebElement locationDropdown;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_6_1_1_2_1_widget")
	WebElement department;
	
	@FindBy(id = "dijit_form_FilteringSelect_1")
	WebElement section;
	
	@FindBy(id = "dijit_form_FilteringSelect_2")
	WebElement subSection;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_2_1_1_1_1_2_1_1_2_1_widget")
	WebElement region;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_2_1_1_1_1_3_1_1_2_1_widget")
	WebElement subRegion;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_2_1_1_1_1_4_1_1_2_1_widget")
	WebElement field;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_2_1_1_1_1_5_1_1_2_1_widget")
	WebElement platform;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_2_1_1_1_1_6_1_1_2_1_widget")
	WebElement activityCategory;
	
	@FindBy(id = "dijit_form_FilteringSelect_3")
	WebElement costCategory;
	
	@FindBy(id = "dijit_form_FilteringSelect_4")
	WebElement productType;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_3_1_1_1_1_2_1_1_2_1_widget")
	WebElement people;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_3_1_1_1_1_3_1_1_2_1_widget")
	WebElement environment;
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_3_1_1_1_1_4_1_1_2_1_widget")
	WebElement assetIntegrity;
	
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_3_1_1_1_1_5_1_1_2_1_widget")
	WebElement reputation;
	
	/*@FindBy(xpath = "//*[@id='div_8_1_2']/button")
	WebElement saveButton;*/
	
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	
	@FindBy(xpath = "//div[@class='Coach_ProgressIcon_hide']/img")
	WebElement loadingImg;
	
	
	@FindBy(id = "div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_2_1_1_2_1_span")
	WebElement activityID;
	
	@FindBy(xpath = "//div[@id='widget_dijit_form_FilteringSelect_1']/../div[3]/span")
	WebElement sectionValidationCoach;
	
	@FindBy(xpath = "//div[@id='widget_div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_2_1_1_1_1_6_1_1_2_1_widget']/../div[3]/span")
	WebElement activityCategoryvalidationcoach;
	
	
	WebDriver driver;
	
	public ActivityRegistrationPage1(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	CommonActions act = new CommonActions();

	public void clickActivityRegLink() throws InterruptedException {
		
		hamburgerLink.click();
		Thread.sleep(1000);
		activityRegLink.click();		
	}
	
	public void enterLocation() {
		
		try {
			Thread.sleep(2000);
			
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='OE2.1 Register Activity Manually ']")));
			
			Thread.sleep(2000);
			driver.findElement(By.id("dijit_form_ComboBox_0")).sendKeys("actName");
			//driver.findElement(By.id("widget_div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_5_1_1_2_1_widget")).click();
			
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		/*locationDropdown.click();
		locationDropdown.sendKeys("Location-1");*/
		
		/*Actions act = new Actions(driver);
		act.sendKeys(locationDropdown, "Location-1").sendKeys(Keys.ENTER);
		act.sendKeys(Keys.ENTER);*/
		
		act.enterValuesInDropdown(driver, locationDropdown, "Location-1");
	}
	
	public void selectDepartment() {
		
		act.enterValuesInDropdown(driver, department, "L1 - Operations Assurance");
	}
	
	public void selectSection() {
		
		act.enterValuesInDropdown(driver, section, "L1 - Integrated Activity Planning");
	}
	
	public void selectRegion() {
		
		act.enterValuesInDropdown(driver, region, "Region-1");
	}
	
	public void selectField() {
		
		act.enterValuesInDropdown(driver, field, "FIELD-1");
	}
	
	public void selectPlatform() {
		
		act.enterValuesInDropdown(driver, platform, "Platform-183");
	}
	

	public void selectActivityCategory() {
		
		act.enterValuesInDropdown(driver, activityCategory, "Asset Integrity");
	}
	
	
	public void selectCostCategory() {
		
		act.enterValuesInDropdown(driver, costCategory, "Capital Expenditure");
	}
	
	
	public void selectProductType() {
		
		act.enterValuesInDropdown(driver, productType, "Common");
	}
	
	
	public void selectPeople() {
		
		act.enterValuesInDropdown(driver, people, "A1 - Low");
	}
	
	public void selectEnvironment() {
		
		act.enterValuesInDropdown(driver, environment, "A1 - Low");
	}
	
	
	public void selectAssetIntegrity() {
			
		act.enterValuesInDropdown(driver, assetIntegrity, "A1 - Low");
	}
	

	public void selectReputation() {
		
		act.enterValuesInDropdown(driver, reputation, "A1 - Low");
	}
	
	
	public void clickSave() {
		
		saveButton.click();
	}
	
	
	public void waitForLoadingImage() {
		
		try {
			
			//System.out.println(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='Coach_ProgressIcon_hide']/img")).toString());
			
			WebDriverWait wait = new WebDriverWait(driver, 8);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='Coach_ProgressIcon_hide']/img")));
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
			readActivityID();
		}
		
	}
	
	
	public void readActivityID() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(Exception.class);
		
		
		WebElement actID = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver1) {
		
				return driver1.findElement(By.id("div_26_1_1_2_2_3_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_2_1_1_2_1_span"));
			}
			
		});
		
		
		System.out.println(actID.getText());
	}
	
	
	public boolean verifyAlertMsgDisplayed() {
		
		boolean flag;
		
		try {
			System.out.println(sectionValidationCoach.getAttribute("span"));
			flag = false;
		} catch (Exception e) {
			// TODO: handle exception
			flag = true;
		}
		
		return flag;
	}
}
