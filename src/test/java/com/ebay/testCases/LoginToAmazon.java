package com.ebay.testCases;

import org.testng.annotations.Test;

import com.ebay.pageObjects.HomePage;
import com.ebay.pageObjects.LoginPage;
import com.ebay.resources.Base;

public class LoginToAmazon extends Base {
	
	public LoginPage loginPage;
	public HomePage homePage;
	
	@Test
	public void launchApp() throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		loginPage.clickUseDifferentAccountButton();
		loginPage.enterEmail("suresh.chudoji@gmail.com");
		loginPage.clickContinue();
		loginPage.enterPassword("Gemini@123");
		loginPage.clickLogin();
		Thread.sleep(3000);
		
		homePage.selectLanguage();
		homePage.searchItem("65 inch tv");
		
		System.out.println("TV Searched");
		
	}
	

}
