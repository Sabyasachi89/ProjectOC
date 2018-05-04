package pagesOperations;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Preconditions;

import commonFunctions.CommonActions;
import pageDataReading.PECCheckListExcelData;
import pageDataReading.PageLocatorsAndData;

public class PECCheckListPage {
	
	//PageLocatorsAndData pageLocatorsAndData = new PageLocatorsAndData(); //related to single page read flow.
	
	PECCheckListExcelData pecCheckListExcelData = PECCheckListExcelData.getPECCheckListExcelDataObject();
	CommonActions commonActions = new CommonActions();
	
	WebDriver driver;
	HashMap<String, By> locator;
	HashMap<String, String> fieldValueMap;
	WebElement element;
	int optionIndex;
	
	public PECCheckListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		/*locator = pageLocatorsAndData.readLocator("PECCheckList"); //corresponding to single page read flow.
		fieldValueMap = pageLocatorsAndData.getFieldValue();*/
		
		locator = pecCheckListExcelData.getMapLocator(); //corresponding to whole workbook read flow.
		fieldValueMap = pecCheckListExcelData.getFieldValueMap();
	}
	
	public int getCheckListIndex(String checkListOption) {
		
		int index = 0;
		
		if(checkListOption.equalsIgnoreCase("Yes"))
			index = 0;
		else if (checkListOption.equalsIgnoreCase("No")) {
			index = 1;
		}else if (checkListOption.equalsIgnoreCase("NA")) {
			index = 2;
		}
		
		return index;
	}
	
	
	public void switchToPECCheckList() {
		
		driver.findElement(locator.get("pecCheckListLink")).click();
	}
	
	public void selectStatutoryCheck1() {
		
		commonActions.fluentWaitFunction(driver, locator, "statutoryCheck1");
		optionIndex = getCheckListIndex(fieldValueMap.get("statutoryCheck1"));
		driver.findElements(locator.get("statutoryCheck1")).get(optionIndex).click();
	}
	
	public void selectStatutoryCheck2() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("statutoryCheck2"));
		driver.findElements(locator.get("statutoryCheck2")).get(optionIndex).click();
	}
	
	public void selectGeneralSOWCheck() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("generalSOWCheck"));
		driver.findElements(locator.get("generalSOWCheck")).get(optionIndex).click();
	}
	
	public void selectShutDownCheck() {
			
		optionIndex = getCheckListIndex(fieldValueMap.get("shutDownCheck"));
		driver.findElements(locator.get("shutDownCheck")).get(optionIndex).click();
	}
	
	public void selectTwoYearTurnaroundCheck() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("twoYearTurnaroundCheck"));
		driver.findElements(locator.get("twoYearTurnaroundCheck")).get(optionIndex).click();
	}
	
	public void selectProdImpactCheck() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("prodImpactCheck"));
		driver.findElements(locator.get("prodImpactCheck")).get(optionIndex).click();
	}
	
	public void selectPOBCheck() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("pobCheck"));
		driver.findElements(locator.get("pobCheck")).get(optionIndex).click();
	}
	
	public void selectManPowerCheck() {
			
		optionIndex = getCheckListIndex(fieldValueMap.get("manPowerCheck"));
		driver.findElements(locator.get("manPowerCheck")).get(optionIndex).click();
	}
	
	public void selectResourcesCheck() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("resourcesCheck"));
		driver.findElements(locator.get("resourcesCheck")).get(optionIndex).click();
	}
	
	public void selectTwoYearMaterialsCheck() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("twoYearMaterialsCheck"));
		driver.findElements(locator.get("twoYearMaterialsCheck")).get(optionIndex).click();
	}
	
	public void selectOneYearTurnaroundCheck1() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("oneYearTurnaroundCheck1"));
		driver.findElements(locator.get("oneYearTurnaroundCheck1")).get(optionIndex).click();
	}
	
	public void selectOneYearTurnaroundCheck2() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("oneYearTurnaroundCheck2"));
		driver.findElements(locator.get("oneYearTurnaroundCheck2")).get(optionIndex).click();
	}
	
	public void selectOneYearMaterialsCheck() {
		
		optionIndex = getCheckListIndex(fieldValueMap.get("oneYearMaterialsCheck"));
		driver.findElements(locator.get("oneYearMaterialsCheck")).get(optionIndex).click();
	}
	
	
	public void clickSaveButton() {
		
		driver.findElement(locator.get("saveButton")).click();
	}
	
	public void clickSubmitButton() {
		
		driver.findElement(locator.get("submitButton")).click();
		commonActions.waitFunction(3000);
	}
	
	public void fillTwoYearPlanCriteriaCheckList() {
		
		switchToPECCheckList();
		selectStatutoryCheck1();
		selectStatutoryCheck2();
		selectGeneralSOWCheck();
		selectShutDownCheck();
		selectTwoYearTurnaroundCheck();
		selectProdImpactCheck();
		selectPOBCheck();
		selectManPowerCheck();
		selectResourcesCheck();
		selectTwoYearMaterialsCheck();
	}
	
	public void fillOneYearPlanCriteriaCheckList() {
		
		selectOneYearTurnaroundCheck1();
		selectOneYearTurnaroundCheck2();
		selectOneYearMaterialsCheck();
	}
	
	public void submitActivityRegistration() {
		
		driver.findElement(locator.get("yesButtonSumitDialogBox")).click();
	}
}
