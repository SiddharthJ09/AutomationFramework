package com.servicenow.utils;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;

public class ReporterLog {
	
	
	@Test
	public void reporter() throws IOException, FilloException{
		
		Reader objDataDictionary = new Reader();
			
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("C:\\Users\\hp-pc\\Desktop\\ServiceStack\\ServiceNow\\Reports\\learn.html");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		
		ExtentTest logger = extentReports.createTest(objDataDictionary.getData("TestCaseName"));
		
		
		logger.log(Status.INFO, "Test Case to Create New Incident");
		
		logger.log(Status.PASS,"Title verified");
		
		
		
		logger.pass("This is description", MediaEntityBuilder.createScreenCaptureFromPath("path of acreen shot").build());
		logger.pass("This is description", MediaEntityBuilder.createScreenCaptureFromPath("path of acreen shot").build());
		
	}

}
