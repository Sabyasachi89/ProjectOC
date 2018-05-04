package pageDataReading;

import java.util.HashMap;

import org.openqa.selenium.By;

public class ActivityOverviewExcelData {

	private HashMap<String, By> mapLocator = new HashMap<String, By>();

	private HashMap<String, String> fieldValueMap = new HashMap<String, String>();

	private static ActivityOverviewExcelData activityOverviewExcelData = new ActivityOverviewExcelData();
	
	public static ActivityOverviewExcelData getActivityOverviewExcelDataObject() {
		
		return activityOverviewExcelData;
	}
	
	public HashMap<String, By> getMapLocator() {
		return mapLocator;
	}

	public void setMapLocator(HashMap<String, By> mapLocator) {
		this.mapLocator = mapLocator;
	}

	public HashMap<String, String> getFieldValueMap() {
		return fieldValueMap;
	}

	public void setFieldValueMap(HashMap<String, String> fieldValueMap) {
		this.fieldValueMap = fieldValueMap;
	}
	
}
