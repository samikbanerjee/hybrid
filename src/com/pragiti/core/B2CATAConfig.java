package com.pragiti.core;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;

public class B2CATAConfig {
	//protected static final Logger LOG = Logger.getLogger(B2CATAConfig.class);
	protected static final Logger LOG = LogManager.getLogger(B2CATAConfig.class);
	static String propFileName = "config/local.properties";
	static InputStream inputStream;
	static Properties prop = new Properties();
	static B2CATAConfig obj = new B2CATAConfig();

	B2CATAConfig() {
		// for lazy initialization
		if (inputStream == null) {
			inputStream = getClass().getClassLoader().getResourceAsStream(
					propFileName);
		}
	}

	/*
	 * code to return value against key from property file
	 */
	public static String getString(String key) {
		String result = key;
		try {
			if (inputStream != null && prop != null) {
				prop.load(inputStream);
				return prop.getProperty(key) == null ? key:prop.getProperty(key);
			} else {
				throw new FileNotFoundException("property file '"
						+ propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			LOG.error("Exception: " + e);
		} 
		return result;
	}

}
