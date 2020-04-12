package com.ebay.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ebay.pageObjects.HomePage;
import com.ebay.pageObjects.LoginPage;
import com.ebay.resources.BaseClass;
import com.ebay.utilities.ReadConfig;

public class LoginAndSearchProductTest extends BaseClass {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public ReadConfig config;
	@Test
	public void launchApp() throws InterruptedException, IOException {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		config = new ReadConfig();
		
		loginPage.clickUseDifferentAccountButton();
		loginPage.enterEmail(config.getProperty("username"));
		loginPage.clickContinue();
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickLogin();
		Thread.sleep(3000);
		
		homePage.selectLanguage();
		homePage.searchItem(config.getProperty("searchKey"));
		
		System.out.println("TV Searched");
		
	}
	

}
