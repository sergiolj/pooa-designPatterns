package designPatterns.singleton.logMessages;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LogService {
    private static LogService instance;
    private PrintWriter logFile;

    private LogService() {
        try{
            this.logFile = new PrintWriter(new FileWriter("log.txt", true));
        }catch(IOException e){
            System.out.println("An error occurred while trying to open the log file.");;
        }

    }

    public static LogService getInstance() {
        if (instance == null) {
            instance = new LogService();
        }
        return instance;
    }

    public void log(String message) {
        this.logFile.printf("Date/Time: %-20s | Error msg: %-20s\n", LocalDateTime.now(), message);
        this.logFile.flush();
    }
}
