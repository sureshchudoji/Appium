package com.ebay.resources;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public abstract class base {
	
	public static AppiumDriver<AndroidElement> driver;
	public static DesiredCapabilities cap;
	public static WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi-K20");
		cap.setCapability("udid", "23f2db35");
		cap.setCapability("automationName", "Uiautomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("waitForIdleTimeout", "3000");
		cap.setCapability("disableWindowAnimation", "true");
		cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		cap.setCapability("noReset", "false");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/applicationPath/Amazon_shopping.apk");
		
		try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<AndroidElement>(url, cap);
			System.out.println("App launched successfully!");		
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());			
		}

	}
	
	@AfterClass
	public void afterClass() {
		driver.resetApp();
		driver.quit();
	}
	
	
	//public void swipe(int x_start, int y_start, int x_stop, int y_stop, int duration) {
 	//
	//	new TouchAction(driver).press(PointOption.point(x_start, y_start))
	//			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
	//			.moveTo(PointOption.point(x_stop, y_stop)).release().perform();
	//}
	

}
