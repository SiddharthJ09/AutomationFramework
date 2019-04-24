package com.servicenow.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Reader {

	
	public String getData(String cKeys) throws FilloException {
	
		Recordset rs;
		String query;
		
		Fillo  fi = new Fillo();
		Connection cn = fi.getConnection("TestData/TestData.xls");
		
		query = "Select * from Sheet1";
		rs= cn.executeQuery(query);
		Map<String, String> formdata = null; 
		while(rs.next()) {
			
			
			formdata = new HashMap<String, String>();
			ArrayList <String> key = rs.getFieldNames(); //new ArrayList<>();
			
			key = rs.getFieldNames();
			
			for(int i=0;i<key.size();i++) {
//				System.out.println(key.get(i));  // gives column names
				formdata.put(key.get(i), rs.getField(key.get(i)));
			}	
		}
			
		rs.close();
		cn.close();
		String string=formdata.get(cKeys);
//		System.out.println("------------------"+formdata.get(cKeys));
		
		return string;
	}
	
	
}


	

	

