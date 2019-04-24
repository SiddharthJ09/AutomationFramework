package com.servicenow.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OHRM_MenuBar extends BasePage {

	public OHRM_MenuBar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 @FindBy(xpath="//*[text()='PIM']")
	  public  WebElement lblPIM;
	 
	 @FindBy(xpath="//*[text()='Add Employee']")
	  public  WebElement lblAddEmplyee;
	 	 
	 @FindBy(xpath="//input[@id='btnAdd']")
	  public  WebElement btnAdd;
	
	 @FindBy(xpath="//div[@class ='menu']//b")
	 public WebElement lblMenuOptions;
	
	

	@Override
	public void waitForPageToLoad() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
