package com.pragiti.report;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.reporters.EmailableReporter2;

public class B2CATAEmailableReport extends EmailableReporter2{
	@Override  
	protected PrintWriter createWriter(String outdir) throws IOException 
	{
		String outfile=outdir.concat("//Emailable_Reports");

		File reports = new File(outfile);

		reports.mkdir();

		String fileName = new SimpleDateFormat("yyyyMMdd'_'hhmmss").format(new Date());
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(reports,"emailable-report_"+fileName+".html"))));
	}
}


