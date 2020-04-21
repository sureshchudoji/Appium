package com.ebay.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	static Logger logger = LogManager.getLogger();

	public static void info(String message) {
		logger.info(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
		//Log.error(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
		//Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}

}
