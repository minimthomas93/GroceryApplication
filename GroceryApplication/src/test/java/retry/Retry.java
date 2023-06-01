package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer{
int count=0;
int retryLimit=2;

@Override
public boolean retry(ITestResult result) {
	if(count<retryLimit)
	{
		count++;
		return true;
	}
	// TODO Auto-generated method stub
	return false;
}
}
