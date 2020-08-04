package com.autodeskcrm.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;


/**
 * 
 * @author suma
 *
 */
public class ReadDataFromProperty {
	
	
	public String fetchdata(String key) throws Throwable {
		
			/* step 1 : create java representation object of the physical File  */
			 FileInputStream fis = new FileInputStream("E:\\TYSS\\Vtiger_org\\resourses\\data.properties");
			 
			/* step 2 : using properties class load all the Key in to java Object*/
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 
			 /* step-3:read data from properties file */
			String value = pObj.getProperty(key);
			
			return value;

	}

}






