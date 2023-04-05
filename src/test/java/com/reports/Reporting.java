package com.reports;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * @author ajina 22-03-2023
 * @param jsonFile
 * @see Used to generate JVM report
 */
public class Reporting extends BaseClass {

	public static void generateJVMReport(String jsonFile) {
		File reportLoc = new File(getProjectPath() + "\\target");

		Configuration con = new Configuration(reportLoc, "OMRBranch");

		con.addClassifications("platform", "windows 10");
		con.addClassifications("sprint", "27");
		con.addClassifications("author", "Greens");

		List<String> li = new LinkedList<String>();
		li.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(li, con);
		builder.generateReports();

	}

}
