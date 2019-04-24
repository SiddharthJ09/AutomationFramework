package com.servicenow.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class CreateTestngXML {

	public static void createFile() throws IOException {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		Recordset rs = null;
		FileWriter write = null;
		
		try {
				System.out.println("Creating TestNG.xml file.....");
				Fillo  fi = new Fillo();
				cn = fi.getConnection("TestData/TestInstruction.xls");
				
				String query = "Select * from Sheet3 where ef ='Yes'";
				rs= cn.executeQuery(query);
				
				File newXmlFile = new File("OHRM_config.xml");
				boolean checkflag = newXmlFile.exists();
						
				if(!checkflag) {
					newXmlFile.createNewFile();
				}
				
				write= new FileWriter("OHRM_config.xml");
				write.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE suite SYSTEM 'http://testng.org/testng-1.0.dtd'> ");
				write.write("\n<suite name=\"DemoSuite\" parallel=\"false\"> \n\n\t<test name=\"DemoSuite\">\n\t\t<parameter name=\"Browser\" value=\"chrome\" />\n\t\t<classes>");
							
				while(rs.next()) {
				
				write.write("\n\t\t\t<class name=\"com.servicenow.test."+rs.getField("tcname")+"\"></class>");
//				 createTestngXmlFile(rs.getField("Component"));rs.getField("Component")
				}
			 
				write.write("\n\t\t</classes>\n\t</test>\n</suite>");
				write.close();
				System.out.println("TestNG.xml file created successfully.");
				Thread.sleep(5000);
			 
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			rs.close();
			cn.close();
		}

	}

}
