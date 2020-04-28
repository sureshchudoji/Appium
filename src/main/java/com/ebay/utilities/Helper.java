package com.ebay.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.ebay.utilities.BaseClass;
import com.ebay.utilities.Log;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;

public class Helper {

	//Takes the screenshot & saves with the screen name passed to the method
	public static void getScreenshot(String screenName) throws IOException, InterruptedException {
		Thread.sleep(Constants.MIN_WAIT);
		String date = new SimpleDateFormat("ddMMyyyy")
				.format(Calendar.getInstance().getTime());
		String dateTime = new SimpleDateFormat("ddMMyyyyhhmmss")
				.format(Calendar.getInstance().getTime());

		File sourceFile = ((TakesScreenshot) BaseClass.driver)
				.getScreenshotAs(OutputType.FILE);
		
		String fileName = dateTime + "-" + screenName+".png";

		FileUtils.copyFile(sourceFile, 
				new File(System.getProperty("user.dir") + "\\screenshots\\" + date + "\\" + fileName));

		Log.info("Screenshot captured with file name - " + fileName);
	}

	//Changes the screen orientation 
	public static void rotateScreen(String orientationType) {

		if(orientationType.equalsIgnoreCase("LANDSCAPE")) {

			BaseClass.driver.rotate(ScreenOrientation.LANDSCAPE);
			Log.info("Screen orientation changed to " + BaseClass.driver.getOrientation());
		} 
		else if(orientationType.equalsIgnoreCase("PORTRAIT")) {

			BaseClass.driver.rotate(ScreenOrientation.PORTRAIT);
			Log.info("Screen orientation changed to "+ BaseClass.driver.getOrientation());
		} 
		else {
			Log.error("Wrong screen orientation");
		}
	}

}

