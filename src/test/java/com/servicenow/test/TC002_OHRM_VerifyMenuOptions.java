package com.servicenow.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.servicenow.pages.OHRM_LoginPage;



public class TC002_OHRM_VerifyMenuOptions extends TestBase {
	

	@Test
	public void OHRM_VerifyMenuOptions() throws IOException {
		OHRM_LoginPage login = new OHRM_LoginPage(driver);
		try
		{
		
			String [] options = {"Leave","Time","My Info","Performance","Directory"};
				
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			login.OHRM_Login();
				
			ArrayList <String> menus = new ArrayList<String>();
			List <WebElement> menuoption = driver.findElements(By.xpath("//div[@class ='menu']//b"));
			
			
			for (int i=0;i<menuoption.size();i++) {
				menus.add(menuoption.get(i).getText());
			}
			
			  for(int i=0;i<options.length;i++){
				
					if(menus.contains(options[i])) {
						System.out.println(options[i]+" element available.");
						GenerateReport().log(Status.PASS,"Menu Option "+options[i]+" available.");
					}else {
						System.out.println(options[i]+" not element available.");
						GenerateReport().log(Status.FAIL,"Menu Option "+options[i]+" not available.");
					}
							
				}
			
				
		}
		catch(Exception e) {
			
		}
		finally
		{
			OHRM_LoginPage.OHRM_Logout();
		}
				
	}
	

}
