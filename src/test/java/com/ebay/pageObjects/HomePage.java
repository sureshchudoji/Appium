package com.ebay.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.resources.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BaseClass {
	
	public HomePage(AppiumDriver<AndroidElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(driver, this);
	}

	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public WebElement searchTextBox;
	
	@AndroidFindBy(id="ap_email_login")
	public WebElement emailTextBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'65 inch tv')]")
	public WebElement searchedItem;
	
	@AndroidFindBy(xpath="//*[contains(@text,'English')]")
	public WebElement englishRadioOption;
	
	@AndroidFindBy(xpath="//*[@text='Save Changes']")
	public WebElement saveChangesButton;
	
	
	public void selectLanguage() throws InterruptedException {
		System.out.println("Language");
		Thread.sleep(10000);
		englishRadioOption.click();
		saveChangesButton.click();
		Thread.sleep(3000);
		System.out.println("Language Selected");
	}	
	
	
	public void searchItem(String itemName) throws InterruptedException {
		searchTextBox.sendKeys(itemName);
		searchTextBox.click();
		searchedItem.click();
		Thread.sleep(5000);
		System.out.println("Item searched");
		//wait.until(ExpectedConditions.visibilityOf(useDifferentAccountButton)).click();
	}
	
	

}
