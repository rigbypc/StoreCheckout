package test.point.of.sale;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

public class TestLogging {

	private static Logger rootLogger = LogManager.getLogger();
	private static Logger fileLogger = LogManager.getLogger("migration");
	
	//@Test
	public void testRoot() {
	
		rootLogger.debug("Debug");
		rootLogger.info("Info");
		rootLogger.error("Error");
	}

	@Test
	public void testFile() {
	
		fileLogger.debug("Debug");
		fileLogger.info("Info");
		fileLogger.error("Error");
	}

}
