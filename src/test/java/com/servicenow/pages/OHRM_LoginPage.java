package com.servicenow.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.servicenow.test.TestBase;
import com.servicenow.utils.UtilityHelper;

public class OHRM_LoginPage extends BasePage {

	public OHRM_LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='txtUsername']")
	  public  WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	  public static WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	  public static WebElement btnLogin;
	
	@FindBy(xpath="//a[@id='welcome']")
	  public static  WebElement lnkWelcomeAdmin;
	
	@FindBy(xpath="//a[text()='Logout']")
	  public static WebElement lnkLogout;
	
	@FindBy(xpath="//span[@id='spanMessage']")
	  public static WebElement lblErrorMessage;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	  public static WebElement imgOrangeHRMIcon;
	
	
	
	
	
	
	
	public void OHRM_Login() throws IOException {
		
		try {
			
			UtilityHelper.setText(txtUsername, "Admin");
			UtilityHelper.setText(txtPassword, "admin123");
			UtilityHelper.Click(btnLogin, "Login Button");
								
			if( lnkWelcomeAdmin.isDisplayed()) {
				System.out.println("Logged in Successfully.");
				ReportStep().log(Status.PASS, "Logged in Successfully.");
				
			}else {
				System.out.println("Failed to Login.");
				String errorTxt = lblErrorMessage.getText();
				ReportStep().fail("Failed to Login. "+errorTxt,
						MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
			}
							
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ReportStep().log(Status.FAIL, "Failed to Login. Exception Occured");
		}
		
	}
	
	
	public static void OHRM_Logout() throws IOException {
		
		try {
			
			UtilityHelper.Click(lnkWelcomeAdmin, "Click on Welcome Admin");
			Thread.sleep(2000);
			UtilityHelper.Click(lnkLogout, "Click on Logout");
			
			if(imgOrangeHRMIcon.isDisplayed()) {
				ReportStep().log(Status.PASS, "Logged Out Successfully.");
			}else {
				ReportStep().log(Status.FAIL, "Signing Off was Unsuccessful.");
			}
			
		}
		catch(Exception e) {
			ReportStep().log(Status.FAIL, "Exception occured while Signing off.");
		}
		
	}
	
	
	
	
	

	@Override
	public void waitForPageToLoad() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
