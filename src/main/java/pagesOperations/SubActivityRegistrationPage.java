package pagesOperations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.CommonActions;
import pageDataReading.PageLocatorsAndData;
import pageDataReading.SubActivityRegistrationExcelData;

public class SubActivityRegistrationPage {

	//PageLocatorsAndData sdata = new PageLocatorsAndData();	// corresponding to single page read flow.
	
	SubActivityRegistrationExcelData subActivityRegistrationExcelData = SubActivityRegistrationExcelData.getSubActivityRegistrationExcelDataObject();
	
	CommonActions commonActions = new CommonActions();
	
	WebDriver driver;
	HashMap<String, By> locator;
	HashMap<String, String> fieldValueMap;
	WebElement element;
	
	int currentMonth;
	int presentDay;
	int twoYearOptimisationMonth;
	int twoYearOtimisationDate;
	int currentYear;
	int twoYearOptimisationYear;
	
	String earliestStartDate;
	String latestEndDate;
	
	List<WebElement> subActivityTableElements;
	
	public SubActivityRegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		/*locator = sdata.readLocator("subActivity"); // corresponding to single page read flow.
		fieldValueMap = sdata.getFieldValue();*/
		
		/*corresponding to whole workbook read flow.*/
		
		locator = subActivityRegistrationExcelData.getMapLocator();		
		fieldValueMap = subActivityRegistrationExcelData.getFieldValueMap();
	}
	
	public void waitFunction(long timeInMillis) throws InterruptedException {
		
		Thread.sleep(timeInMillis);
	}
	
	public void switchToSubActivityTab() {
		
		driver.findElement(locator.get("subActivityLink")).click();
	}

	public void enterSubActivityName() {
		
		commonActions.fluentWaitFunction(driver, locator, "subActivityName");
		element = driver.findElement(locator.get("subActivityName"));
		element.clear();
		commonActions.waitFunction(1000);
		element.sendKeys(fieldValueMap.get("subActivityName"));
	}
	
	public void enterSubActivityCategory() {
		
		element = commonActions.fluentWaitFunction(driver, locator, "subActivityCategory");
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("subActivityCategory"));
	}
	
	public void enterSubActivityType() {
			
		element = driver.findElement(locator.get("subActivityType"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("subActivityType"));
	}
	
	public void enterRegulatoryCompliance() {
		
		element = driver.findElement(locator.get("regulatoryCompliance"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("regulatoryCompliance"));
	}
	
	public void getCurrentDate() {
		
		LocalDate localDate = LocalDate.now();
		presentDay = localDate.getDayOfMonth();
		currentMonth = localDate.getMonthValue();
		currentYear = localDate.getYear();
	}
	
	
	public void datesForTwoYearOptimisation() {
		
		twoYearOptimisationMonth = currentMonth + 4;
		
		if (twoYearOptimisationMonth>12) {
			
			twoYearOptimisationMonth = twoYearOptimisationMonth-12;
		}
			
		if (currentMonth>=9) {
			
			twoYearOptimisationYear = currentYear+1;
		}
		else {
			
			twoYearOptimisationYear = currentYear;
		}
		
		earliestStartDate = "02/"+"0"+String.valueOf(twoYearOptimisationMonth)+"/"+String.valueOf(twoYearOptimisationYear);
		latestEndDate = "21/"+"0"+String.valueOf(twoYearOptimisationMonth)+"/"+String.valueOf(twoYearOptimisationYear);
	}
	
	
	public void enterStartDate() {
		
		driver.findElement(locator.get("earliestStartDateInput")).sendKeys(earliestStartDate);
	}
	
	
	public void enterEndDate() {
		
		driver.findElement(locator.get("latestEndDateInput")).sendKeys(latestEndDate);
	}
	
	
	public void enterDuration() {
		
		element = driver.findElement(locator.get("duration"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("duration"));
	}
	
	
	public void enterServiceCost() {
		
		element = driver.findElement(locator.get("estimatedServiceCost"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("estimatedServiceCost"));
	}
	
	
	public void estimatedMaterialCost() {
			
		element = driver.findElement(locator.get("estimatedMaterialCost"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("estimatedMaterialCost"));
	}

	
	public void estimatedVesselCost() {
		
		element = driver.findElement(locator.get("estimatedVesselCost"));
		commonActions.enterValuesInDropdown(driver, element, fieldValueMap.get("estimatedVesselCost"));
	}
	
	
	public void clickOnSave() {
		
		driver.findElement(locator.get("saveButton")).click();
	}
	
	
	public void clickOnSubmit() {
		
		driver.findElement(locator.get("submitButton")).click();
	}
	
	
	public void subActivityIdDisplayed() {
		
		System.out.println(driver.findElement(locator.get("subActivityId")).getText());
	}
	
	
	public String readSubActivityId() {
		
		/*element = commonActions.fluentWaitFunction(driver, locator, "subActivityIdInTable");
		commonActions.waitFunction(1000);
		System.out.println(driver.findElement(locator.get("subActivityIdInTable")).getText());
		return element.getText();*/
		
		//subActivityTableElements = commonActions.fluentWaitFunctionForListOfWebElements(driver, locator, "subActivityDetailsInTable");
		
		commonActions.fluentWaitFunction(driver, locator, "radioButtonSubActivityTable");
		
		commonActions.waitFunction(2000);
		
		System.out.println(driver.findElements(locator.get("subActivityDetailsInTable")).get(0).getText());
		return driver.findElements(locator.get("subActivityDetailsInTable")).get(0).getText();
	}
	
	public String readSubActivityName() {
		
		/*System.out.println(driver.findElement(locator.get("subActivityNameInTable")).getText());
		return driver.findElement(locator.get("subActivityNameInTable")).getText();*/
		
		return driver.findElements(locator.get("subActivityDetailsInTable")).get(1).getText();
	}
	
	public String readEarlyStartDate() {
		
		/*System.out.println(driver.findElement(locator.get("EarlyStartDateInTable")).getText());
		return driver.findElement(locator.get("EarlyStartDateInTable")).getText();*/
		
		return driver.findElements(locator.get("subActivityDetailsInTable")).get(2).getText();
	}

	public String readEarlyEndDate() {
		
		/*System.out.println(driver.findElement(locator.get("EarlyEndDateInTable")).getText());
		return driver.findElement(locator.get("EarlyEndDateInTable")).getText();*/
		
		return driver.findElements(locator.get("subActivityDetailsInTable")).get(3).getText();
	}
	
	public String enteredEarlyStartDate() {
		
		return earliestStartDate;
	}
	
	public String enteredEarlyEndDate() {
			
		return latestEndDate;
	}
	
	public String subActivityName() {
		
		return fieldValueMap.get("subActivityName");
	}
	
	public boolean blankSubActivityCategoryValidation() {
		
		element = commonActions.fluentWaitFunction(driver, locator, "blankSubActivityCategoryValidation");  //need to check its requirement.
		
		commonActions.waitFunction(3000);
		boolean flag;
		try {
			
			String styleValue = element.getAttribute("style");
			if(styleValue.equalsIgnoreCase(""))
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
			flag = true;
		}
		
		return flag;
	}
	
	
	public void createSubActivity() {
		
		switchToSubActivityTab();
		commonActions.waitFunction(2000);
		enterSubActivityName();
		enterSubActivityCategory();
		enterSubActivityType();
		enterRegulatoryCompliance();
		getCurrentDate();
		datesForTwoYearOptimisation();
		enterStartDate();
		enterDuration();
		enterEndDate();
		enterServiceCost();
		estimatedMaterialCost();
		estimatedVesselCost();
		clickOnSave();
		
		commonActions.waitFunction(2000);
		subActivityIdDisplayed();
	}
	
	
	public void fillSubActivityDetailsWithBlankFields() {
		
		switchToSubActivityTab();
		enterSubActivityName();
		enterSubActivityType();
		enterRegulatoryCompliance();
		getCurrentDate();
		datesForTwoYearOptimisation();
		enterStartDate();
		enterDuration();
		enterEndDate();
		enterServiceCost();
		estimatedMaterialCost();
		estimatedVesselCost();
	}
	
	
	public void fillSubActivityBlankFields() {
		
		enterSubActivityCategory();
	}
	
}
