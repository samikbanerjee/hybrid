package com.pragiti.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp {

	public static  String stamp(){
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date); 
	}
}
