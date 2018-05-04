package IAPTest.activityRegistration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driverConfiguration.IEDriverConfiguration;
import other.PageInitialization;
import pagesOperations.ActivityRegistrationPage;
import pagesOperations.SubActivityRegistrationPage;

public class SubActivityCreationTest {
	
	WebDriver driver;
	SubActivityRegistrationPage subActivityRegistrationPage;
	ActivityRegistrationPage activityRegistrationPage;
	
	PageInitialization pageInitialization;
	
	@BeforeClass
	public void initialization() {
		
		driver = IEDriverConfiguration.getDriver();
		subActivityRegistrationPage = new SubActivityRegistrationPage(driver);
		pageInitialization = PageInitialization.getPageInitializationInstance();
		activityRegistrationPage = pageInitialization.getActivityRegistrationPage();
	}
	
	
	@Test
	public void testBlankMandatoryFieldValidation() {
		
		subActivityRegistrationPage.fillSubActivityDetailsWithBlankFields();
		subActivityRegistrationPage.clickOnSave();
		Assert.assertTrue(subActivityRegistrationPage.blankSubActivityCategoryValidation());
	}

	
	@Test(dependsOnMethods="testBlankMandatoryFieldValidation")
	public void testCreatedSubActivityDetails() {
		
		subActivityRegistrationPage.fillSubActivityBlankFields();
		subActivityRegistrationPage.clickOnSave();
		Assert.assertTrue(subActivityRegistrationPage.readSubActivityId().contains(activityRegistrationPage.returnActivityID()));
		Assert.assertEquals(subActivityRegistrationPage.readSubActivityName(), subActivityRegistrationPage.subActivityName());
		Assert.assertEquals(subActivityRegistrationPage.readEarlyStartDate(), subActivityRegistrationPage.enteredEarlyStartDate());
		Assert.assertEquals(subActivityRegistrationPage.readEarlyEndDate(), subActivityRegistrationPage.enteredEarlyEndDate());
	}	
	
}
