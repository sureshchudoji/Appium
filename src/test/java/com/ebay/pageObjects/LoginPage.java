package com.ebay.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.ebay.resources.BaseClass;
import com.ebay.resources.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseClass {
	
	public LoginPage(AppiumDriver<AndroidElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sso_use_different_account")
	public AndroidElement useDifferentAccountButton;
	
	@AndroidFindBy(id="ap_email_login")
	public AndroidElement emailTextBox;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Continue')]")
	public AndroidElement continueButton;
	
	@AndroidFindBy(id="ap_password")
	public AndroidElement passwordTextBox;
	
	@AndroidFindBy(id="signInSubmit")
	public AndroidElement loginButton;
	
	//Click on the button 'Use Different Account'
	public void clickUseDifferentAccountButton() {
		wait.waitForElement(useDifferentAccountButton).click();
		Log.info("Clicked on Use Different Account button");
		
	}
	
	//Type email in username textbox
	public void enterEmail(String email){
		wait.waitForElement(emailTextBox).clear();
		emailTextBox.sendKeys(email);
		Log.info("Email entered");
	}
	
	//type password in password field
	public void enterPassword(String password){
		wait.waitForElement(passwordTextBox).clear();
		passwordTextBox.sendKeys(password);
		Log.info("Password entered");
	}
	
	//Click on Login button
	public void clickLogin() {
		wait.waitForElement(loginButton).click();
		Log.info("Clicked on Login button");
		
	}
	
	//Click on Continue button
	public void clickContinue() {
		wait.waitForElement(continueButton).click();
		Log.info("Clicked on Continue button");
	}

}
