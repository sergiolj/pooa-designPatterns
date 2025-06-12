package designPatterns.singleton.configManager;

public class Main {
    public static void main(String[] args) {
        ConfigManager configManager = ConfigManager.getInstance();
        System.out.println(configManager.getUrlDataBase());
        System.out.println(configManager.getDatabasePort());

    }
}
