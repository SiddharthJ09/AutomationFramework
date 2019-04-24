package com.servicenow.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import com.servicenow.utils.Property;
import com.servicenow.utils.Reader;

public class TestBase extends Reader {

	public static WebDriver driver = null;
	public static String strScreenshotpath;

	static ExtentTest logger = null;
	static ExtentReports extent = getExtent();

	@BeforeMethod
	 @Parameters({"Browser"})
 	public void beforeMethod(String browser) throws IOException, FilloException {
		Reader objDic = new Reader();
//		logger = extent.createTest(objDic.getData("TestCaseName"));
		logger = extent.createTest("TC002_OHRM_VerifyMenuOptions");
		
		System.out.println("Launching "+browser+"......");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		System.out.println();                      
		driver.manage().window().maximize();
		System.out.println(browser+" Browser Launched.");
		System.out.println("Loading URL...");
//		driver.get (Property.get("URL")); //(objDic.getData("URL"));
		driver.get (Property.get("OHRM_URL")); //(objDic.getData("URL"));
//		driver.get("https://dev53617.service-now.com/login.do");
		GenerateReport().log(Status.INFO,browser+" Browser Launched.");
	
	}

	@AfterMethod
	public void afterMethod() {
		extent.flush();
		driver.quit();

	}

	public static ExtentTest GenerateReport() throws IOException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String strDataTime = formatter.format(date).toString();
		String FileName = "ScreenShot" + ((strDataTime.replaceAll(" ", "")).replaceAll("/", "")).replaceAll(":", "");
		
		strScreenshotpath = System.getProperty("user.dir") + "\\test-output\\Screenshot\\" + FileName + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(strScreenshotpath));

		return logger;
	}

	public static ExtentReports getExtent() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\ExecutionReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
