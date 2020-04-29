package com.ebay.utilities;

import java.io.*;
import java.util.*;
public class ReadConfig {
	
	//Get the property value from properties file by passing the key
   public String getProperty(String propertyName) throws IOException {
      FileInputStream fis = null;
      Properties prop = null;
      try {
         fis = new FileInputStream(System.getProperty("user.dir") + "/config/Config.properties");
         prop = new Properties();
         prop.load(fis);
         
      } catch(FileNotFoundException fnfe) {
         Log.error(fnfe.getMessage());
    	  fnfe.printStackTrace();
      } catch(IOException ioe) {
    	  Log.error(ioe.getMessage());
         ioe.printStackTrace();
      } finally {
         fis.close();
      }
      return prop.getProperty(propertyName);
   }
}	
	
	
	