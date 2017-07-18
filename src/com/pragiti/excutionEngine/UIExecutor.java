/**
 * 
 */
package com.pragiti.excutionEngine;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pragiti.core.BaseSetup;
import com.pragiti.core.TestDataProvider;
import com.pragiti.core.TestDataProvider.TestDataFile;

/**
 * @author Samik
 *
 */
public class UIExecutor extends BaseSetup {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test(dataProvider = "xlsx", dataProviderClass = TestDataProvider.class)
	@TestDataFile(fileName="LogIn.xlsx", testDataSheet="TestData")
	public void execute(String[] sD) throws Exception{
		ActionKeys  acts=new ActionKeys(driver);

		List<TestStep> steps = TestStepsReader.getTestStepsFromXlsx("LogIn.xlsx", "TestCases");
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


	
}
