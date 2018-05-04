package IAPTest.activityRegistration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import driverConfiguration.IEDriverConfiguration;
import driverConfiguration.LoginApplication;
import other.PageInitialization;
import pagesOperations.ActivityRegistrationPage;
import utility.DataReading;

public class ActivityOverviewTest {

	WebDriver driver;
	ActivityRegistrationPage activityRegistrationPage;
	IEDriverConfiguration ieDriverConfiguration;
	
	//PageInitialization is done to use the object of any page class from any of the other classes. Runtime data generated in the UI can be accessed with this way.
	PageInitialization pageInitialization; 
	
	/*@BeforeSuite
	public void loadDataAndConfigureDriver() {
		
		new DataReading();
		ieDriverConfiguration = new IEDriverConfiguration();
	}*/
	
	
	@BeforeClass
	public void loginAndInitializePage() {
		
		new DataReading();
		ieDriverConfiguration = new IEDriverConfiguration();
		driver = IEDriverConfiguration.getDriver();
		new LoginApplication(driver);
		
		pageInitialization = PageInitialization.getPageInitializationInstance();
		pageInitialization.setActivityRegistrationPage(driver);
		activityRegistrationPage = pageInitialization.getActivityRegistrationPage();
	}
	
	
	@Test
	public void testValidationDisplayedForBlankMandatoryFields() {
		
		activityRegistrationPage.fillActivityDetailsWithBlankFields();
		activityRegistrationPage.clickSave();
		
		Assert.assertTrue(activityRegistrationPage.blankSectionValidation());
		Assert.assertTrue(activityRegistrationPage.blankActivityCategoryValidation());
	}
	
	
	@Test(dependsOnMethods="testValidationDisplayedForBlankMandatoryFields")
	public void testActivityIDIsGeneratedWhenClickedOnSave() {
		
		activityRegistrationPage.fillBlankFields();
		activityRegistrationPage.clickSave();
		activityRegistrationPage.readActivityID();
		Assert.assertTrue(activityRegistrationPage.returnActivityID().contains("A2018"));
	}
	
	
}
