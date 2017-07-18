/**
 * 
 */
package com.pragiti.excutionEngine;

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
	public String testCase;
	public String testData;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
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
			int tDindex;
			try {
				tDindex=Integer.parseInt(step.getInputValue());
			} catch (Exception e) {
				tDindex=0;
			}
			
			acts.executeAction(step.getKeyWord(), step.getElementIdentifier(), step.getElementIdentifierValue(), 
					sD[tDindex], step.getAssertValue());
		}
		
	}
	
	
	@DataProvider(name="uiexecxlsx")
	public Object[][] XLSX() throws Exception{		
		Object[][] testObjArray = ExcelUtils.getTableArray(CoreConstants.TestDataPath + testData,"TestData",1,0);
		return (testObjArray);
	}


	
}
