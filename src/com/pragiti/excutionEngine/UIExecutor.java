/**
 * 
 */
package com.pragiti.excutionEngine;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pragiti.core.BaseSetup;
import com.pragiti.core.CoreConstants;
import com.pragiti.core.ExcelUtils;

/**
 * @author Samik
 *
 */
public class UIExecutor extends BaseSetup {

	public WebDriver driver;
	public String appUrl;
	public String testCase;
	public String testData;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		appUrl =getAppUrl();
	}
	
	@BeforeTest
	public void setUpTest(){
		testCase=getTestCase();
		testData=getTestData();
	}
	
	
	@Test(dataProvider = "uiexecxlsx")
	public void execute(String[] sD) throws Exception{
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
			else if (step.getInputValue().startsWith("#")) {
				String matchVal=step.getInputValue().substring(1);
				sData=sD[getTestDataIndex(matchVal)];
			}
			else {
				sData=step.getInputValue();
			}
			
			System.out.println("Executing Step: --"+step.getTestCaseId());
			acts.executeAction(appUrl, step.getKeyWord(), step.getElementIdentifier(), step.getElementIdentifierValue(), 
					sData, step.getAssertValue());
		}
		
	}
	
	
	@DataProvider(name="uiexecxlsx")
	public Object[][] XLSX() throws Exception{		
		Object[][] testObjArray = ExcelUtils.getTableArray(CoreConstants.TestDataPath + testData,"TestData",1,0);
		return (testObjArray);
	}

	
	public int getTestDataIndex(String matchVal) throws Exception{
		List<String> aL=Arrays.asList(ExcelUtils.getRowArray(CoreConstants.TestDataPath + testData,"TestData", 0));
		return aL.indexOf(matchVal);
	}

}
