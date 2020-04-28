package com.ebay.pageObjects;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.ebay.utilities.BaseClass;
import com.ebay.utilities.Constants;
import com.ebay.utilities.Helper;
import com.ebay.utilities.Log;

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
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'apple iphone 11')]")
	public AndroidElement searchedItem;
	
	@AndroidFindBy(xpath="//*[contains(@text,'English')]")
	public AndroidElement englishRadioOption;
	
	@AndroidFindBy(xpath="//*[@text='Save Changes']")
	public AndroidElement saveChangesButton;
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/web_home_shop_by_department_label")
	public AndroidElement shopByCategory;
	
	//Select preferred language English/Hindi if user prompts with language selection
	public void selectLanguage() throws InterruptedException, IOException {
		Thread.sleep(Constants.MAX_WAIT);		
		Boolean langPopup = driver.findElementsByXPath("//android.view.View[@text='close']").size() != 0;
		
		//Check whether the language selection pop-up is displayed
		if(langPopup) {
			try {
				wait.waitForElement(englishRadioOption).click();
				wait.waitForElement(saveChangesButton).click();
				Log.info("English language option selected");
			} 
			catch (Exception e) {
				Log.info(e.getMessage());
				Helper.getScreenshot("LanguageSelection");
			}
		}
	}	
	
	//Search an item
	public void searchItem(String itemName) throws InterruptedException {
		wait.waitForElement(searchTextBox).sendKeys(itemName);
		wait.waitForElement(searchedItem).click();
		Log.info("Item search successfully");
	}
	
	//Returns the element shopByCategory
	public AndroidElement getShopByCategory() {
		return wait.waitForElement(shopByCategory);
		//return shopByCategory;
	}

}
