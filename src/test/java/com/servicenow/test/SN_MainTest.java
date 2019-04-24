//package com.servicenow.test;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.codoid.products.exception.FilloException;
//import com.servicenow.pages.IncidentNewRecordPage;
//import com.servicenow.pages.LoginPage;
//import com.servicenow.pages.NavigationPanelPage;
//import com.servicenow.utils.Reader;
//import com.servicenow.utils.UtilityHelper;
//
//public class SN_MainTest extends TestBase{
//
//	
//	@Test
//	@Parameters({ "Username", "Password" })
//	public void sn_IncidentTest(String username,String password) throws InterruptedException, FilloException, IOException{
//		
//		boolean iflag = false; 
//		Reader objDataDictionary = new Reader();
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.waitForPageToLoad();
//		loginPage.invoke(username,password);
//		
//		NavigationPanelPage nPage = new NavigationPanelPage(driver);
//		nPage.waitForPageToLoad();
//		String actualTitle = driver.getTitle();
//		String expectedTitle = "My Homepage 1 | ServiceNow";
//		UtilityHelper.verifyTitle(actualTitle, expectedTitle);
//		
//		nPage.txtboxFilterNavigator.sendKeys("Incident");
//		UtilityHelper.waitForElement(nPage.linkCreateNew);
//		nPage.linkCreateNew.click();
//		
//		Thread.sleep(2000);
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
//			
//		
//		//Form
//		IncidentNewRecordPage incidentNewRecordPage = new IncidentNewRecordPage(driver);
//		incidentNewRecordPage.waitForPageToLoad();
//	
//	
//		String IncidentNumber = incidentNewRecordPage.txtboxIncidentNumber.getAttribute("value");
//		UtilityHelper.selectOptionFromList(incidentNewRecordPage.listCategory, objDataDictionary.getData("Category"));
//			
//		
//		String parentWindow = driver.getWindowHandle();
//		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
//		
//		Set <String> newWindow = driver.getWindowHandles();
//	
//		for(String handle: newWindow){
//           
//			if(!handle.equals(parentWindow)){
//				
//	            driver.switchTo().window(handle);
//	            Thread.sleep(1000);
//	            System.out.println("Title of the new window: " +driver.getTitle());
//	             
//	            
//	            String [] arrCaller = objDataDictionary.getData("Caller").split(" "); 
//	            wait.until(ExpectedConditions.visibilityOf(incidentNewRecordPage.txtboxSearchName));
//	        	UtilityHelper.setText(incidentNewRecordPage.txtboxSearchName, arrCaller[0].trim());
//	        	Thread.sleep(2000);
//	        	incidentNewRecordPage.txtboxSearchName.sendKeys(Keys.ENTER);
//	        	Thread.sleep(2000);
//	        	
//	        	List<WebElement> listCallers = incidentNewRecordPage.tblUsers.findElements(By.xpath("//tbody/tr/td[3]/a"));
//	        	
//	        	for(int i=0;i<listCallers.size();i++) {
//	        		
//	        		if(listCallers.get(i).getText().equalsIgnoreCase(objDataDictionary.getData("Caller"))) {
//	        			GenerateReport().log(Status.PASS,"Caller "+objDataDictionary.getData("Caller")+" Found.");
//	        			listCallers.get(i).click();
//	        			driver.switchTo().window(parentWindow);
//	        			break;
//	        		}else {
//	        			
//	        			iflag = true;
//	        			
//	        		 
//	        		}
//	        	}
//	        
//            }
//			
//			if(iflag) {
//				GenerateReport().fail("Caller "+objDataDictionary.getData("Caller")+" not Found.",
//        				MediaEntityBuilder.createScreenCaptureFromPath(TestBase.strScreenshotpath).build());
//			}
//			
//			
//        }
//	
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
//		
//		UtilityHelper.selectOptionFromList(incidentNewRecordPage.listSubCategory,objDataDictionary.getData("Subcategory"));
//			
//		UtilityHelper.setText(incidentNewRecordPage.txtboxBusinessService, objDataDictionary.getData("Business Service"));
//		
//		UtilityHelper.setText(incidentNewRecordPage.txtboxConfigurationItem, objDataDictionary.getData("Configuration Item"));
//		
//		UtilityHelper.selectOptionFromList(incidentNewRecordPage.listContactType, objDataDictionary.getData("Contact type"));
//		
//		UtilityHelper.selectOptionFromList(incidentNewRecordPage.listImpact, objDataDictionary.getData("Impact"));
//		
//		UtilityHelper.selectOptionFromList(incidentNewRecordPage.listUrgency, objDataDictionary.getData("Urgency"));
//		
//		UtilityHelper.setText(incidentNewRecordPage.txtboxAssignmentGrp, objDataDictionary.getData("Assignment group"));
//		
//		UtilityHelper.setText(incidentNewRecordPage.txtboxAssigedTo, objDataDictionary.getData("Assigned to"));
//		Thread.sleep(1000);
//		incidentNewRecordPage.txtboxAssigedTo.sendKeys(Keys.DOWN);
//		Thread.sleep(1000);
//		incidentNewRecordPage.txtboxAssigedTo.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
//		
//		UtilityHelper.setText(incidentNewRecordPage.txtboxShortDescp, objDataDictionary.getData("Short description"));
//		
//		UtilityHelper.setText(incidentNewRecordPage.txtboxDescription, objDataDictionary.getData("Description"));
//		
//		incidentNewRecordPage.btnSubmit.click();
//		driver.switchTo().defaultContent();
//		
//		
//		//Naviagte to ALl 
//		
//		nPage.linkAll.click();
//		
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
//		
//	 	UtilityHelper.setText(incidentNewRecordPage.txtboxSearchName, IncidentNumber);
//	 	incidentNewRecordPage.txtboxSearchName.sendKeys(Keys.ENTER);
//    	Thread.sleep(2000);
//    	
//		List<WebElement> listIncidentNumbers = driver.findElements(By.xpath("//table[@id='incident_table']//tbody/tr/td[3]/a"));
//		
//		for(int i=0;i<listIncidentNumbers.size();i++) {
//    		
//    		if(listIncidentNumbers.get(i).getText().equalsIgnoreCase(IncidentNumber)) {
//    			    Assert.assertEquals(IncidentNumber, listIncidentNumbers.get(i).getText());			
//    			    GenerateReport().log(Status.PASS,"Incident Record Found.| Incident Number:"+IncidentNumber);
//    			break;
//    		}else {
//    			GenerateReport().log(Status.FAIL,"Incident Record not Found.| Incident Number:"+IncidentNumber);
//    		}
//    	}
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//}
