package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/reports/index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("OrangeHRM Automation");
            reporter.config().setDocumentTitle("Resultados de Pruebas");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}