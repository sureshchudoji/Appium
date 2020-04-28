package com.ebay.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	static Logger logger = LogManager.getLogger(Log.class);
	
	//Writes information messages to log file
	public static void info(String message) {
		logger.info(message);
	}

	//Writes warning messages to log file
	public static void warn(String message) {
		logger.warn(message);
	}

	//Writes error messages to log file
	public static void error(String message) {
		logger.error(message);
		//Log.error(message);
	}

	//Writes fatal messages to log file
	public static void fatal(String message) {
		logger.fatal(message);
		//Log.fatal(message);
	}

	//Writes debug messages to log file
	public static void debug(String message) {
		Log.debug(message);
	}

}
