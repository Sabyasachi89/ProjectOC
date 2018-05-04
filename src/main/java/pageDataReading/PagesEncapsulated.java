package pageDataReading;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;

public class PagesEncapsulated {
	
	HashMap<String, By> mapLocator = new HashMap<String, By>();

	HashMap<String, String> fieldValueMap = new HashMap<String, String>();

	
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
