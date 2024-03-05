package CommonUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LIstenerImplementation implements ITestListener {
	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("TestScript execution is started");
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+"TestScript execution is started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
	//Reporter.log(methodname+"TestScript execution is success",true);
	//Test.
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+"TestScript execution is failed"+message,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+"TestScript execution is skipped",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		JavaUtil jutil=new JavaUtil();
		// TODO Auto-generated method stub
		//Reporter.log("To strt the execution",true);
		//create the object of class ExtentSparkReporter
		// use ExtentSparkReporter class just to configure extent report
		ExtentSparkReporter reporter= new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		// to sset 
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Organization");
		// use 
	    report =new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("window10", "Google Chrome");
		report. setSystemInfo("122.0.6261.95", "vtiger");
		report.setSystemInfo("Author", "Saket");
		
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("To finish the execution",true);
		report.flush();
	}

	

}
