package pageDataReading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupRefImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.DataReading;

public class PageLocatorsAndData {

	String value;
	
	HashMap<String, ArrayList> pageObj = new HashMap<String, ArrayList>();

	//HashMap<String, String> fieldValueMap = new HashMap<String, String>();
	
	/*public HashMap<String, By> readLocator(String sheetName) {
		
		ExcelReading obj = new ExcelReading();
		pageObj =  obj.pageValues(sheetName);
		
		By locator = null;
		HashMap<String, By> mapLocator = new HashMap<String, By>();
		
		for(Map.Entry<String, ArrayList> entry : pageObj.entrySet()) {
			
			ArrayList webElementData = entry.getValue();
			
			String locatorVariable = (String) webElementData.get(0);
			String locatorValue = (String) webElementData.get(1);
			
			String fieldValue = String.valueOf(webElementData.get(2)); //Converting the double values to String
			String locatorName = entry.getKey(); 
		
		
			if(locatorVariable.equalsIgnoreCase("id"))
				locator = By.id(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("xpath"))
				locator = By.xpath(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("linkText"))
				locator = By.linkText(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("name"))
				locator = By.name(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("tagName"))
				locator = By.tagName(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("partialLinkText"))
				locator = By.partialLinkText(locatorValue);
			
			mapLocator.put(locatorName, locator);
			fieldValueMap.put(locatorName, fieldValue);
		}
		
		return mapLocator;
	}*/
	
	/*public HashMap<String, String> getFieldValue(){
	
		return fieldValueMap;
	}
	
	private By By(String key) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	HashMap<String, By> mapLocator;
	HashMap<String, String> fieldValueMap;
	
	public void readLocator(String sheetName, HashMap<String, ArrayList> excelDataMap) {
		
		/*ExcelReading obj = new ExcelReading();
		pageObj =  obj.pageValues(sheetName);*/
		
		By locator = null;
		mapLocator = new HashMap<String, By>();
		fieldValueMap = new HashMap<String, String>();
		
		for(Map.Entry<String, ArrayList> entry : excelDataMap.entrySet()) {
			
			ArrayList webElementData = entry.getValue();
			
			String locatorVariable = (String) webElementData.get(0);
			String locatorValue = (String) webElementData.get(1);
			
			String fieldValue = String.valueOf(webElementData.get(2)); //Converting the double values to String
			String locatorName = entry.getKey(); 
		
		
			if(locatorVariable.equalsIgnoreCase("id"))
				locator = By.id(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("xpath"))
				locator = By.xpath(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("linkText"))
				locator = By.linkText(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("name"))
				locator = By.name(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("tagName"))
				locator = By.tagName(locatorValue);
			else if (locatorVariable.equalsIgnoreCase("partialLinkText"))
				locator = By.partialLinkText(locatorValue);
			
			mapLocator.put(locatorName, locator);
			
			fieldValueMap.put(locatorName, fieldValue);
		}
		
		
		assignPageData(sheetName); //Assigning the page data.
		
	}
	
	
	
	public void assignPageData(String sheetName) {
		
		if (sheetName.equalsIgnoreCase("SubActivity")) {
			
			SubActivityRegistrationExcelData subActivityRegistration = SubActivityRegistrationExcelData.getSubActivityRegistrationExcelDataObject();
			subActivityRegistration.setMapLocator(mapLocator);
			subActivityRegistration.setFieldValueMap(fieldValueMap);
		}
		
		else if (sheetName.equalsIgnoreCase("PECCheckList")) {
			
			PECCheckListExcelData pecCheckListExcelData = PECCheckListExcelData.getPECCheckListExcelDataObject();
			pecCheckListExcelData.setMapLocator(mapLocator);
			pecCheckListExcelData.setFieldValueMap(fieldValueMap);
		}
		
		else if (sheetName.equalsIgnoreCase("ActivityOverview")) {
			
			ActivityOverviewExcelData activityOverviewExcelData = ActivityOverviewExcelData.getActivityOverviewExcelDataObject();
			activityOverviewExcelData.setMapLocator(mapLocator);
			activityOverviewExcelData.setFieldValueMap(fieldValueMap);
		}
		
	}
	

}
