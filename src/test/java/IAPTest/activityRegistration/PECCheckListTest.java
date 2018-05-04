package IAPTest.activityRegistration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driverConfiguration.IEDriverConfiguration;
import pagesOperations.PECCheckListPage;

public class PECCheckListTest {
	
	WebDriver driver;
	PECCheckListPage pecCheckListPage;
	
	@BeforeClass
	public void initialization() {
		
		driver = IEDriverConfiguration.getDriver();
		pecCheckListPage = new PECCheckListPage(driver);
	}
	
	@Test
	public void fillPECCheckListAndSubmit() {
		
		pecCheckListPage.fillTwoYearPlanCriteriaCheckList();
		pecCheckListPage.fillOneYearPlanCriteriaCheckList();
		pecCheckListPage.clickSaveButton();
		pecCheckListPage.clickSubmitButton();
	}

	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
