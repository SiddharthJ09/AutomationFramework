package com.servicenow.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.servicenow.test.TestBase;

public abstract  class BasePage extends TestBase {


	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public abstract void waitForPageToLoad() throws IOException;
	
	public static ExtentTest ReportStep() throws IOException{
		return GenerateReport();
		
	}

}
