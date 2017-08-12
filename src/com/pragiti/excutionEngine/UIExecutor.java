/**
 * 
 */
package com.pragiti.excutionEngine;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.pragiti.core.BaseSetup;
import com.pragiti.core.CoreConstants;
import com.pragiti.core.ExcelUtils;
import com.pragiti.core.Timestamp;

/**
 * @author Samik
 *
 */
public class UIExecutor extends BaseSetup {

	public WebDriver driver;
	public String testCase;
	public String testData;
	public ExtentTest test;
	public  String testName;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	
	@BeforeTest
	public void setUpTest(final ITestContext testContext){
		testCase=getTestCase();
		testData=getTestData();
		testName = testContext.getName();
	}
	
	
	@Test(dataProvider = "uiexecxlsx")
	public void execute(String[] sD) throws Exception{
		test=extent.createTest(testName, "Based on the Test Scripts provided in file - "+testCase);
		String applUrl = getAppUrl();
		ActionKeys  acts=new ActionKeys(driver);

		List<TestStep> steps = TestStepsReader.getTestStepsFromXlsx(testCase, "TestCases");
		for (TestStep step : steps) {
			String sData;
			if(step.getInputValue()==null){
				sData="";
			}
			else if (step.getInputValue()=="") {
				sData="";
			}
			else if (step.getInputValue().startsWith(CoreConstants.TESTDATA_NOTATION)) {
				String matchVal=step.getInputValue().substring(1);
				sData=sD[getTestDataIndex(matchVal)];
			}
			else {
				sData=step.getInputValue();
			}
			
			if(step.getElementIdentifierValue().equalsIgnoreCase(CoreConstants.GET_FROM_TEST_DATA)==true){
				step.setElementIdentifierValue(sData);
			}
			
			
				acts.executeAction(applUrl, step.getKeyWord(), step.getElementIdentifier(), step.getElementIdentifierValue(), 
						sData, step.getDescription());
				
				test.pass("Executing step: "+step.getTestCaseId()+"; "+step.getDescription()+"; "+step.getKeyWord()+"->"+
				step.getElementIdentifier()+" = "+step.getElementIdentifierValue()+" / "+sData);
				
		}
		
	}
	
    @AfterMethod
    public synchronized void afterMethod(ITestResult result) throws IOException{
    	if (result.getStatus() == ITestResult.FAILURE)
    	{
    		String screenShotPath = this.captureScreenshot(driver, testName);
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
    	}
        else if (result.getStatus() == ITestResult.SKIP)
        {
        	
        	String screenShotPath = this.captureScreenshot(driver, testName);
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
    	}
        else
            test.pass("Test passed");
        extent.flush();
    }
	
	
	@DataProvider(name="uiexecxlsx")
	public Object[][] XLSX() {		
		Object[][] testObjArray = null;
		try {
				testObjArray= ExcelUtils.getTableArray(CoreConstants.TestDataPath + testData,"TestData",1,0);
			} 
		catch (Exception e) 
			{
				testObjArray=new String[1][1];
				testObjArray[0][0]="0";
			}
		return (testObjArray);
	}

	
	public int getTestDataIndex(String matchVal) throws Exception{
		List<String> aL=Arrays.asList(ExcelUtils.getRowArray(CoreConstants.TestDataPath + testData,"TestData", 0));
		return aL.indexOf(matchVal);
	}

	public String captureScreenshot(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = CoreConstants.TESTREPORTPATH+screenShotName+"_"+Timestamp.stamp()+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);                
        return dest;
    }
}
