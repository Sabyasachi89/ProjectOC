package GuruBank.GuruBank;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count = 0;
	int retLimit = 4;
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		if (count<retLimit) {
			
			count++;
			return true;
		}
		
		return false;
	}

}
