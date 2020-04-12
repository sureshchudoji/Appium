package com.ebay.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.resources.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseClass {
	
	public LoginPage(AppiumDriver<AndroidElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(driver, this);
	}
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sso_use_different_account")
	public WebElement useDifferentAccountButton;
	
	@AndroidFindBy(id="ap_email_login")
	public WebElement emailTextBox;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Continue')]")
	public WebElement continueButton;
	
	@AndroidFindBy(id="ap_password")
	public WebElement passwordTextBox;
	
	@AndroidFindBy(id="signInSubmit")
	public WebElement loginButton;
	
	
	public void clickUseDifferentAccountButton() {
		useDifferentAccountButton.click();
		System.out.println("Clicked Button");
		//wait.until(ExpectedConditions.visibilityOf(useDifferentAccountButton)).click();
	}
	
	public void enterEmail(String email){
		emailTextBox.clear();
		//wait.until(ExpectedConditions.visibilityOf(emailTextBox)).clear();
		emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password){
		passwordTextBox.clear();
		//wait.until(ExpectedConditions.visibilityOf(passwordTextBox)).clear();
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
		System.out.println("Clicked on Login");
		//wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
	}
	
	public void clickContinue() {
		continueButton.click();
		System.out.println("Clicked on Continue");
	}

}
