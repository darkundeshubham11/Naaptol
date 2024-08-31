package naaptolPOM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;

	public static ExtentReports createInstance(String filePath) {
		spark = new ExtentSparkReporter(filePath);
		spark.config().setDocumentTitle("Naaptol Automation Report");
		spark.config().setReportName("Naaptol Test Automation");
		spark.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Darkunde Shubham");
		extent.setSystemInfo("Environment", "QA");

		return extent;
	}

	public static ExtentTest createTest(String testName) {
		return extent.createTest(testName);
	}
}
