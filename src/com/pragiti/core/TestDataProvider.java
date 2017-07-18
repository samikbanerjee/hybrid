/**
 *
 */
package com.pragiti.core;

import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;



/**
 *
 */
public class TestDataProvider
{
	/**
	 * Provide Name of Test Data File
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface TestDataFile
	{
		/**
		 * @return test data file name
		 */
		String fileName();

		/**
		 * @return lines to be ignored from test data file / default 1
		 */
		int linesToIgnore() default 1;
		
		/*
		 * @return Test data sheet name for xlsx files
		 */
		
		String testDataSheet() default "NOT FOUND";
	}


	/**
	 * @param testMethod
	 * @return Data Array from CSV file
	 * @throws IOException
	 */
	@DataProvider(name = "csv")
	public static String[][] CSV(final Method testMethod) throws IOException
	{
		String testDataFileName = null;
		int linesToIgnore = 0;
		final TestDataFile parameters = testMethod.getAnnotation(TestDataFile.class);

		if (parameters != null)
		{
			testDataFileName = parameters.fileName();
			linesToIgnore = parameters.linesToIgnore();
		}

		//Get Test Data List
		final String file = System.getProperty("user.dir") + "/resources/" + testDataFileName;
		final CSVReader reader = new CSVReader(new FileReader(file), ';');
		final List<String[]> entries = reader.readAll();
		reader.close();


		//Remove lines to ignore
		for (int i = 0; i < linesToIgnore; i++)
		{
			entries.remove(0);
		}

		// Load list in to a 2d array for TestNG data Provider
		final String[][] lines = new String[entries.size()][];
		entries.toArray(lines);
		return lines;
	}
	
	@DataProvider(name="xlsx")
	public Object[][] XLSX(final Method testMethod) throws Exception{

		String testDataFileName = null;
		String testDataSheet=null;
		final TestDataFile parameters = testMethod.getAnnotation(TestDataFile.class);
		if (parameters != null)
		{
			testDataFileName = parameters.fileName();
			testDataSheet=parameters.testDataSheet();
		}
		
		Object[][] testObjArray = ExcelUtils.getTableArray(CoreConstants.TestDataPath + testDataFileName,testDataSheet,1,0);

		return (testObjArray);

	}
	
}
