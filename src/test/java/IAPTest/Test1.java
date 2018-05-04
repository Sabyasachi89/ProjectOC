package IAPTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import driverConfiguration.IEDriverConfiguration;
import driverConfiguration.LoginApplication;
import pagesOperations.ActivityRegistrationPage;
import pagesOperations.PECCheckListPage;
import pagesOperations.SubActivityRegistrationPage;
import utility.DataReading;

public class Test1 {
	
	/*@Test
	public void initiate() {
		
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.ie.driver", "C:\\Users\\sdeb\\eclipse-workspace\\GuruBank\\IEDriverServer.exe");
	}*/
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		DataReading pageElementReading = new DataReading();
		
		IEDriverConfiguration ieDriverConfiguration = new IEDriverConfiguration();
		
		//WebDriver driver = IEDriverConfiguration.getDriver();
		WebDriver driver = ieDriverConfiguration.getDriver();
		
		new LoginApplication(driver);
		
		ActivityRegistrationPage act = new ActivityRegistrationPage(driver);
		
		Thread.sleep(5000);
		
			
			act.clickActivityRegLink();
			
			Thread.sleep(2000);
			act.enterLocation();
			act.selectDepartment();
			act.selectSection();
			act.selectRegion();
			act.selectField();
			act.selectPlatform();
			act.selectActivityCategory();
			act.selectCostCategory();
			act.selectProductType();
			act.selectPeople();
			act.selectEnvironment();
			act.selectAssetIntegrity();
			act.selectReputation();
			act.clickSave();
			//act.waitForLoadingImage();
			Thread.sleep(5000);
			act.readActivityID();
			
			
			SubActivityRegistrationPage sAct = new SubActivityRegistrationPage(driver);
			sAct.createSubActivity();
			
			Thread.sleep(2000);
		
			PECCheckListPage pecPage = new PECCheckListPage(driver);
			pecPage.switchToPECCheckList();
			Thread.sleep(2000);
			pecPage.fillTwoYearPlanCriteriaCheckList();
			pecPage.fillOneYearPlanCriteriaCheckList();
			pecPage.clickSaveButton();
			
			Thread.sleep(2000);
			pecPage.clickSubmitButton();
			
			pecPage.submitActivityRegistration();
			Thread.sleep(2000);
			Thread.sleep(5000);
			driver.quit();
		
	}

}
