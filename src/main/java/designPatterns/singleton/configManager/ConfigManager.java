package designPatterns.singleton.configManager;

//Lazy singleton

public class ConfigManager {
    private static ConfigManager instance;

    private String urlDataBase;
    private int databasePort;

    private ConfigManager() {
        this.urlDataBase = "jdbc:mysql://localhost:myDatabase/";
        this.databasePort = 8080;
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getUrlDataBase() {
        return urlDataBase;
    }

    public void setUrlDataBase(String urlDataBase) {
        this.urlDataBase = urlDataBase;
    }

    public int getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(int databasePort) {
        this.databasePort = databasePort;
    }
}
