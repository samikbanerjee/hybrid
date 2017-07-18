package com.pragiti.core;


/**
 * Global class for all B2CATA constants. You can add global constants for your extension into this class.
 */
public final class CoreConstants 
{
	public static final String EXTENSIONNAME = "B2CATA";

	public static final String HOMEDIRECTORY = System.getProperty("user.dir");
	public static final String DRIVERPATH = HOMEDIRECTORY +"\\resources\\drivers\\";
	public static final String TestDataPath = HOMEDIRECTORY +"\\resources\\testData\\";
	public static final String AUTOSCRIPTPATH = HOMEDIRECTORY +"\\resources\\autoITSript\\";
	
	public static final String HandleAuthenticationScript = "HandleAuthentication.exe";

	public static final String LoginTestDataFile = "login-testdata.xlsx";
	
	public static final String AccountPagesDataFile="account-pages.xlsx";
	
	public static final String UserRegistrationTestDataFile="user-registration.xlsx";
	
	public static final String GuestUserCheckoutDataFile="guest-user-checkout.xlsx";
	
	public static final String LoggedInUserCheckoutDataFile="Logged-in-user-checkout.xlsx";
	
	
	
	private CoreConstants()
	{
		//empty
	}

	// implement here constants used by this extension
}