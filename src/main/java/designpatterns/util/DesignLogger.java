package designpatterns.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DesignLogger{
	private Logger logger;
	private boolean consoleOutputEnabled= false;
	private boolean fileOutputEnabled= false;

	public DesignLogger() {
		this.logger = Logger.getLogger(DesignLogger.class.getName());
		this.logger.setUseParentHandlers(false);
	}

	public void register(String message) {
		this.logger.log(Level.INFO, message);
	}
	
	public void setOutputToConsole() {
		if(!consoleOutputEnabled) {
			ConsoleHandler consoleHandler = new ConsoleHandler();
			SimpleFormatter formatter = new SimpleFormatter();

			consoleHandler.setFormatter(formatter);
			this.logger.addHandler(consoleHandler);
			consoleOutputEnabled = true;
		}
	}

	public void setOutputToFile(String filePath) {
		try {
			if(!fileOutputEnabled) {
				FileHandler fileHandler = new FileHandler(filePath, true);
				this.logger.addHandler(fileHandler);
				fileOutputEnabled = true;
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public Logger getLogger() {
		return this.logger;
	}
}
