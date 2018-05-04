package pagesOperations;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import commonFunctions.CommonActions;
import pageDataReading.ActivityOverviewExcelData;

public class ActivityRegistrationPage {
	
	WebDriver driver;
	CommonActions commonActions = new CommonActions();
	ActivityOverviewExcelData activityOverviewExcelData = ActivityOverviewExcelData.getActivityOverviewExcelDataObject();
	
	HashMap<String, By> locator;
	HashMap<String, String> fieldValueMap;
	WebElement element;
	
	String activityID;
	
	public ActivityRegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		locator = activityOverviewExcelData.getMapLocator();
		fieldValueMap = activityOverviewExcelData.getFieldValueMap();	
	}

	public void clickActivityRegLink() {
		
		System.out.println();
		driver.findElement(locator.get("hamburgerLink")).click();
		commonActions.waitFunction(2000);
		driver.findElement(locator.get("activityRegLink")).click();	
	}
	
	public void switchToActivityRegistrationFrame() {
		
		driver.switchTo().frame(driver.findElement(locator.get("activityRegistrationFrame")));
	}
	
	public void enterActivityName() {
		
		driver.findElement(locator.get("activtyName")).sendKeys(fieldValueMap.get("activtyName"));
	}
	
	public void enterLocation() {
		
		element = driver.findElement(locator.get("locationDropdown"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("locationDropdown"));
	}
	
	public void selectDepartment() {
		
		element = driver.findElement(locator.get("department"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("department"));
	}
	
	public void selectSection() {
			
		element = driver.findElement(locator.get("section"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("section"));
	}
	
	public void selectRegion() {
		
		element = driver.findElement(locator.get("region"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("region"));
	}
	
	public void selectField() {
		
		element = driver.findElement(locator.get("field"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("field"));
	}
	
	public void selectPlatform() {
		
		element = driver.findElement(locator.get("platform"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("platform"));
	}
	

	public void selectActivityCategory() {
		
		element = driver.findElement(locator.get("activityCategory"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("activityCategory"));
	}
	
	
	public void selectCostCategory() {
		
		element = driver.findElement(locator.get("costCategory"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("costCategory"));
	}
	
	public void selectProductType() {
		
		element = driver.findElement(locator.get("productType"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("productType"));
	}
	
	
	public void selectPeople() {
		
		element = driver.findElement(locator.get("people"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("people"));
	}
	
	public void selectEnvironment() {
		
		element = driver.findElement(locator.get("environment"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("environment"));
	}
	
	
	public void selectAssetIntegrity() {
			
		element = driver.findElement(locator.get("assetIntegrity"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("assetIntegrity"));
	}
	

	public void selectReputation() {
		
		element = driver.findElement(locator.get("reputation"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("reputation"));
	}
	
	
	public void clickSave() {
		
		driver.findElement(locator.get("saveButton")).click();
	}
	
	
	public void readActivityID() {
		
		element = commonActions.fluentWaitFunction(driver, locator, "activityID");
		commonActions.waitFunction(3000);
		activityID = element.getText();
	}
	
	public String returnActivityID() {
		
		System.out.println(activityID);
		return activityID;
	}
	
	public boolean blankSectionValidation() {
		
		element = commonActions.fluentWaitFunction(driver, locator, "sectionValidationCoach");
		
		boolean flag;
		try {
			
			String styleValue = element.getAttribute("style");
			if(styleValue.equalsIgnoreCase(""))
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			// TODO: handle exception
			
			flag = true;
		}
		
		return flag;
	}
	
	
	public boolean blankActivityCategoryValidation() {
		
		element = commonActions.fluentWaitFunction(driver, locator, "activityCategoryValidationCoach");
		
		boolean flag;
		try {
			
			String styleValue = element.getAttribute("style");
			if(styleValue.equalsIgnoreCase(""))
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			// TODO: handle exception
			
			flag = true;
		}
		
		return flag;
	}
	
	
	public void fillActivityDetailsWithBlankFields() {
		
		commonActions.waitFunction(5000);
		clickActivityRegLink();
		
		commonActions.waitFunction(1000);
		switchToActivityRegistrationFrame();
		
		commonActions.waitFunction(2000);
		enterActivityName();
		enterLocation();
		selectDepartment();
		selectRegion();
		selectField();
		selectPlatform();
		selectCostCategory();
		selectProductType();
		selectPeople();
		selectEnvironment();
		selectAssetIntegrity();
		selectReputation();
	}
	
	public void fillBlankFields() {
		
		commonActions.waitFunction(2000);
		selectSection();
		selectActivityCategory();
	}
}
