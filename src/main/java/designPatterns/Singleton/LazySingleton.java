package Singleton;

public class LazySingleton {
    private static final LazySingleton instance = new LazySingleton();
    private String data;

    private LazySingleton() {
        this.data = "Hello World";
    }
    public static LazySingleton getInstance() {
        return instance;
    }

    public void sayHello() {
        System.out.println(data);
    }
}
