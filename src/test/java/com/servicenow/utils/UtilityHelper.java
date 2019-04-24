package com.servicenow.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.servicenow.pages.BasePage;
import com.servicenow.test.TestBase;



public class UtilityHelper extends BasePage {

	UtilityHelper(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void waitForElement(WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	public static void verifyText(String actual, String expected) throws IOException {

		ReportStep().log(Status.INFO,"Comparing " + actual + " with " + expected);
		if (actual.equalsIgnoreCase(expected)) {
			
			ReportStep().log(Status.PASS, "Text verified as "+actual);

		} else {
			ReportStep().log(Status.FAIL,"Actual text:" +actual+" does not matches with Expected:"+expected);
			Assert.assertEquals(expected, actual);

		}

	}

	public static void verifyTitle(String actual, String expected) throws IOException {

		ReportStep().log(Status.INFO,"Comparing title" + actual + " with " + expected);
		if (actual.contains(expected)) {
	
			ReportStep().log(Status.PASS, "Logged In Successfully with Service Now.");

		} else {
			ReportStep().fail(actual + " Title not matching with " + expected,
					MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
			Assert.assertEquals(expected, actual);

		}

	}

	public static void selectOptionFromList(WebElement webElement, String value) throws IOException {

		try {
			Thread.sleep(700);
			Select option = new Select(webElement);
			if (!value.isEmpty()) {
				option.selectByVisibleText(value);
				System.out.println("Value Selected from dropdown:"+value);
				// ReportStep().pass("Input set as :"+value,
				// MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
				ReportStep().log(Status.PASS,"Value Selected from dropdown:"+value);
				
			} else {
				ReportStep().fail("Could Not find "+value+" option from dropdown ",
						MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
			}
			Thread.sleep(700);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ReportStep().fail("Could Not find "+value+" option from dropdown or Object",
					MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
		}

	}

	public static void setText(WebElement webElement, String value) throws IOException {

		try {
			Thread.sleep(700);
			if (!value.isEmpty()) {
				webElement.sendKeys(value);
				System.out.println("Value entered as "+value);
				ReportStep().log(Status.PASS, "Input value set as:" + value);
			} else {
				ReportStep().fail("Input set as:" + value,
						MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
			}
			Thread.sleep(700);
		} catch (Exception e) {

			ReportStep().fail("Could not find value "+value+" or Object",
					MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
		}

	}

	public static  void Click(WebElement webElement,String value) throws IOException {
		
		try {		
			if(webElement.isDisplayed()) {
				webElement.click();
				ReportStep().log(Status.PASS,"Clicked on button.");
			}else{
				ReportStep().fail(webElement.getText()+" Element not displayed.", MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
			ReportStep().fail("Exception Occured:" + e,
					MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
			}
		
	}
	@Override
	public void waitForPageToLoad() {

	}

}
