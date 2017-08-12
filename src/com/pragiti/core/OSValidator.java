package com.pragiti.core;

public class OSValidator {


	private static String OS = System.getProperty("os.name").toLowerCase();
	
	
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}
	
	public static String returnOsNm(){
		if (isWindows()) {
			return "Windows";
		} else if (isMac()) {
			return "Mac";
		} else if (isUnix()) {
			return "Linux";
		} else if (isSolaris()) {
			return "Solaris";
		} else {
			return "Unsupported";
		}
	}
}
