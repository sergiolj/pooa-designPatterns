package designpatterns.util;

import java.util.logging.Handler;

public class Main {
	
	public static void main(String[] args) {

		DesignLogger consoleLogger = new DesignLogger();
	
		consoleLogger.setOutputToFile("log.txt");
		consoleLogger.setOutputToConsole();
		
		consoleLogger.register("This is an info message to the console.");
		
		for(Handler handler : consoleLogger.getLogger().getHandlers()) {
			System.out.println("Handler: " + handler.getClass().getName());
		}
	}

}
