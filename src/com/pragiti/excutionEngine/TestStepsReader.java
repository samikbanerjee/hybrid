/**
 * 
 */
package com.pragiti.excutionEngine;

import java.util.ArrayList;
import java.util.List;

import com.pragiti.core.CoreConstants;
import com.pragiti.core.ExcelUtils;

/**
 * @author Samik
 *
 */
public class TestStepsReader{

	public static List<TestStep> getTestStepsFromXlsx(String xlsxfileName, String worksheetName) throws Exception
	{
		List<TestStep> testSteps=new ArrayList<TestStep>();
		Object[][] testObjectArray=ExcelUtils.getTableArray(CoreConstants.TestDataPath +xlsxfileName, worksheetName, 1, 0);
		for (int i = 0; i < testObjectArray.length; i++) {
			Object[] objects = testObjectArray[i];
				TestStep ts=new TestStep();
				ts.setTestCaseId(((String) objects[0]).trim());
				ts.setKeyWord(((String) objects[1]).trim());		
				ts.setElementIdentifier(((String) objects[2]).trim());
				ts.setElementIdentifierValue(((String) objects[3]).trim());
				ts.setInputValue(((String) objects[4]).trim());
				ts.setAssertValue(((String) objects[5]).trim());
				testSteps.add(ts);
		}
		return testSteps;
	}

}
