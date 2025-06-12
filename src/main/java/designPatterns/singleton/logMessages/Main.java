package designPatterns.singleton.logMessages;

public class Main {
    public static void main(String[] args) {
        LogService logService = LogService.getInstance();
        logService.log("Hello World");
        logService.log("Error msg");

    }
}
