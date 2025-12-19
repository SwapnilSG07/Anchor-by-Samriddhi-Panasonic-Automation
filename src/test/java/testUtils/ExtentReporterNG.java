package testUtils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	public static ExtentReports getReporterObject() {

		if (extent == null) {

			// Extent Spark Reporter
			String reportDir = System.getProperty("user.dir") + "/reports";
			new File(reportDir).mkdirs(); // 🔴 REQUIRED

			String path = reportDir + "/index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Panasonic Test Results");
			reporter.config().setDocumentTitle("Test Report");

			// MAIN EXTENT OBJECT
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Swapnil Gadekar");
		}
		return extent;
	}

}
