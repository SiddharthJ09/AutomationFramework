package com.servicenow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncidentNewRecordPage extends BasePage {

	public IncidentNewRecordPage(WebDriver driver) {
		super(driver);
		
	}
	
	 @FindBy(xpath="//input[@id='sys_original.incident.number']")
	  public  WebElement txtboxIncidentNumber;
	 
	 @FindBy(xpath="//input[@id='sys_display.incident.caller_id']")
	  public  WebElement txtboxCaller;
	 
	 @FindBy(xpath="//select[@id='incident.category']")
	  public  WebElement listCategory;
	 
	 @FindBy(xpath="//select[@id='incident.subcategory']")
	  public  WebElement listSubCategory;
	 
	 @FindBy(xpath="//input[@id='sys_display.incident.business_service']")
	  public  WebElement txtboxBusinessService;
	 
	 @FindBy(xpath="//input[@id='sys_display.incident.cmdb_ci']")
	  public  WebElement txtboxConfigurationItem;
	 
	 @FindBy(xpath="//select[@id='incident.contact_type']")
	  public  WebElement listContactType;
	 
	 @FindBy(xpath="//select[@id='incident.impact']")
	  public  WebElement listImpact;
	 
	 @FindBy(xpath="//select[@id='incident.urgency']")
	  public  WebElement listUrgency;
	 
	 @FindBy(xpath="//input[@id='sys_display.incident.assignment_group']")
	  public  WebElement txtboxAssignmentGrp;
	 
	 @FindBy(xpath="//input[@id='sys_display.incident.assigned_to']")
	  public  WebElement txtboxAssigedTo;
	 
	 @FindBy(xpath="//input[@id='incident.short_description']")
	  public  WebElement txtboxShortDescp;
	 
	 @FindBy(xpath="//textarea[@id='incident.description']")
	  public  WebElement txtboxDescription;
	 
	 @FindBy(xpath="//button[@id='sysverb_insert_bottom']")
	  public  WebElement btnSubmit;
	 	
	 @FindBy(xpath="//iframe[@id='gsft_main']")
	  public  WebElement frameNewIncidentForm;
	 
	 @FindBy(xpath="//span[contains(@id,'hide_search')]//input")
	  public  WebElement txtboxSearchName;
	 
	 @FindBy(xpath="//table[@id='sys_user_table']")
	  public  WebElement tblUsers;
	 
	

	 
	 public void waitForPageToLoad(){
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOf(txtboxCaller));
	 }
	 
	 
	 

}
