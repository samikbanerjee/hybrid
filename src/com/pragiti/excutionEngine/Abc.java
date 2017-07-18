package com.pragiti.excutionEngine;

import org.testng.annotations.Test;

import com.pragiti.core.TestDataProvider;
import com.pragiti.core.TestDataProvider.TestDataFile;

public class Abc {

	
	@Test(dataProvider = "xlsx", dataProviderClass = TestDataProvider.class)
	@TestDataFile(fileName="LogIn.xlsx", testDataSheet="TestData")
	public void def(String[] sD) throws InterruptedException{
		//List<String> testDataRow= Arrays.asList(sD);
		
		System.out.print("This is the username: "+ sD[0]);
		System.out.print("###");
		System.out.print("This is the password: "+ sD[2]);
		System.out.print("###");
		System.out.print("This is the validator: "+ sD[1]);
		System.out.println("");
	}
}

