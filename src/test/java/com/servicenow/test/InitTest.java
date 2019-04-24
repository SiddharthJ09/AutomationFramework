package com.servicenow.test;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.servicenow.utils.CreateTestngXML;

public class InitTest {

	
	@Test
	public void testDemoMethod() throws Exception
	{
		System.out.println("in test testDemoMethod ");
		
		File file = new File("D:\\ServiceNowLatest\\15th April\\ServiceStack\\OHRM_config.xml");
			file.delete();
			
			CreateTestngXML.createFile();
	}
}
