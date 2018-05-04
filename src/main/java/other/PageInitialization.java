package other;

import org.openqa.selenium.WebDriver;

import pagesOperations.ActivityRegistrationPage;

public class PageInitialization {
	
	private static PageInitialization pageInitialization = new PageInitialization();
	
	private PageInitialization() {
		
	}
	
	public static PageInitialization getPageInitializationInstance() {
		
		return pageInitialization;
	}
	
	
	ActivityRegistrationPage activityRegistrationPage;

	public ActivityRegistrationPage getActivityRegistrationPage() {
		
		return activityRegistrationPage;
	}

	public void setActivityRegistrationPage(WebDriver driver) {
		
		activityRegistrationPage = new ActivityRegistrationPage(driver);
	}
	

}
