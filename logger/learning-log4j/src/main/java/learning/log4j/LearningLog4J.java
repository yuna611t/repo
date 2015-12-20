package learning.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LearningLog4J {
	
	private static final Logger logger = LogManager.getLogger("HelloWorld");

	public static void main(String[] args) {
		System.out.println("Hello World!!");

		logger.trace("Hello, World");
		logger.debug("Hello, World");
		logger.info("Hello, World");
		logger.warn("Hello, World");
		logger.error("Hello, World");
		logger.fatal("Hello, World");

	}

}
