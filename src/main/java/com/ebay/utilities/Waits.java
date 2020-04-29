package com.ebay.utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;

public class Waits extends BaseClass {
	
	public WebDriverWait wait;
	
	//Waits for an element to be visible for a specified time 
	public AndroidElement waitForElement(AndroidElement androidElement) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(androidElement));
		}catch (Exception ex) {
			Log.error(ex.getMessage());
		}
		return androidElement;
	}
}
