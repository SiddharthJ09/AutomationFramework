package com.servicenow.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.servicenow.test.TestBase;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	 @FindBy(xpath="//input[@id='user_name']")
	  public  WebElement txtboxUserName;
	 
	 @FindBy(xpath="//input[@id='user_password']")
	  public  WebElement txtboxPassword;
	 
	 @FindBy(xpath="//button[@id='sysverb_login']")
	  public  WebElement btnlogin;
	 
	 public void waitForPageToLoad() throws IOException{
		 try{
			 WebDriverWait wait = new WebDriverWait(driver, 20);
			 wait.until(ExpectedConditions.visibilityOf(txtboxUserName));
		 }catch(Exception e){
			 ReportStep().fail("Page Not Found|Page Load Timeout.",
						MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
		 }
		 
	 }

	 
	public void invoke(String username,String password) throws IOException{
		try{
		if(txtboxUserName.isDisplayed() && txtboxPassword.isDisplayed()){
			txtboxUserName.sendKeys(username);
			txtboxPassword.sendKeys(password);
			btnlogin.click();
			
		}else{
			ReportStep().fail("Username / Password field not found.",
					MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
		} }
		catch(Exception e){
			ReportStep().fail("Unable to locate element.",
					MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
			
		}
	}
	 
	 
}
