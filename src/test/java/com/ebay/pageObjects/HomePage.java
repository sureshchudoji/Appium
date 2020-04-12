package com.ebay.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.ebay.resources.BaseClass;
import com.ebay.resources.Constants;
import com.ebay.resources.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BaseClass {
	
	public HomePage(AppiumDriver<AndroidElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public AndroidElement searchTextBox;
	
	@AndroidFindBy(id="ap_email_login")
	public AndroidElement emailTextBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'65 inch tv')]")
	public AndroidElement searchedItem;
	
	@AndroidFindBy(xpath="//*[contains(@text,'English')]")
	public AndroidElement englishRadioOption;
	
	@AndroidFindBy(xpath="//*[@text='Save Changes']")
	public AndroidElement saveChangesButton;
	
	//Select preferred language for app English / Hindi
	public void selectLanguage() throws InterruptedException {
		Thread.sleep(Constants.MAX_WAIT);
		wait.waitForElement(englishRadioOption).click();
		wait.waitForElement(saveChangesButton).click();
		Log.info("English language option selected");
	}	
	
	//Search an item
	public void searchItem(String itemName) throws InterruptedException {
		wait.waitForElement(searchTextBox).sendKeys(itemName);
		wait.waitForElement(searchedItem).click();
		Log.info("Item search successfully");
	}

}
