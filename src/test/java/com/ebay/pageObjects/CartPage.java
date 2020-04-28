package com.ebay.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.ebay.utilities.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends BaseClass {
	
	public CartPage(AppiumDriver<AndroidElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(xpath="(//android.widget.TextView[contains(@text,'Apple iPhone 11')])[2]")
	public AndroidElement productName;
	
	//Returns the element productName
	public AndroidElement getProductName() {
		return wait.waitForElement(productName);
	}

}
