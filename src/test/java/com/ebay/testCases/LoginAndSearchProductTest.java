package com.ebay.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebay.pageObjects.CartPage;
import com.ebay.pageObjects.HomePage;
import com.ebay.pageObjects.LoginPage;
import com.ebay.utilities.BaseClass;
import com.ebay.utilities.Constants;
import com.ebay.utilities.Log;
import com.ebay.utilities.ReadConfig;
import com.ebay.utilities.Helper;
import com.ebay.utilities.ExcelData;

public class LoginAndSearchProductTest extends BaseClass {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	public ReadConfig config;
	public ExcelData data;
	
	@Test
	public void LoginAndSearchTest() throws InterruptedException, IOException {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		config = new ReadConfig();
		data = new ExcelData();
		
		//Get the username & password to login from excel data sheet
		String username = data.getUsername();
		String password = data.getPassword();
		
		loginPage.clickUseDifferentAccountButton();
		loginPage.enterEmail(username);
		loginPage.clickContinue();
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		//Validate the shop by Category label on home screen
		Assert.assertTrue(homePage.getShopByCategory().getText().contains(config.getProperty("shopByCategory")));
		
		Helper.rotateScreen(Constants.LANDSCAPE_MODE);
		Helper.getScreenshot("LogingScreen");
		Helper.rotateScreen(Constants.PORTRAIT_MODE);
		
		homePage.selectLanguage();
		homePage.searchItem(config.getProperty("searchKey"));
		Helper.getScreenshot("SearchResults");
		Log.info("TV searched & selected successful");
		
		String searchedProductName = cartPage.getProductName().getText();
		Log.info("Random product from searched results - "+searchedProductName);
		
		if(searchedProductName.contains(config.getProperty("searchKey"))) { 
			Assert.fail();
		}

	}

}
