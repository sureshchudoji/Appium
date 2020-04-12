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

import com.ebay.resources.Constants;

public abstract class Base {
	
	public static AppiumDriver<AndroidElement> driver;
	public static DesiredCapabilities cap;
	public static WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		cap = new DesiredCapabilities();
		cap.setCapability(Constants.DEVICE_NAME, Constants.REDMI_K20);
		cap.setCapability(Constants.UDID, Constants.DEVICE_ID ); //"udid", "23f2db35");
		cap.setCapability(Constants.AUTOMATION_NAME, Constants.UI_AUTOMATOR1); //"automationName", "Uiautomator1");
		cap.setCapability(Constants.PLATFORM_NAME, Constants.ANDROID); //"platformName", "Android");
		cap.setCapability(Constants.PLATFORM_VERSION, Constants.ANDROID_VERSION); //"platformVersion", "10.0");
		cap.setCapability(Constants.WAIT_FOR_IDLE_TIMEOUT, Constants.IDLE_TIMEOUT); //"waitForIdleTimeout", "3000");
		cap.setCapability(Constants.DISABLE_WINDOW_ANIMATION, Constants.TRUE); //"disableWindowAnimation", "true");
		cap.setCapability(Constants.APP_PACKAGE_, Constants.APP_PACKAGE_NAME_); //"appPackage", "com.amazon.mShop.android.shopping");
		cap.setCapability(Constants.APP_ACTIVITY, Constants.APP_ACTIVITY_NAME); //"appActivity", "com.amazon.mShop.home.HomeActivity");
		cap.setCapability(Constants.NO_RESET, Constants.FALSE); //"noReset", "false");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/app/Amazon_shopping.apk");
		
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
