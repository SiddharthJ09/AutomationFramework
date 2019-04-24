package com.servicenow.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OHRM_AddEmployeePage extends BasePage {

	public OHRM_AddEmployeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement btnSave;
	
	
	@Override
	public void waitForPageToLoad() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
