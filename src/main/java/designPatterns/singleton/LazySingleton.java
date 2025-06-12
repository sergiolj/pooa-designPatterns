package designPatterns.singleton;

/**
 * Esse modelo de implementação não é thread safe, pois em ambientes com muitas threads pode haver
 * o problema de duas threads passarem pelo if do instance == null ao mesmo tempo e acidentalmente criando
 * duas instâncias
 */
public class LazySingleton {
    private static LazySingleton instance;
    private final String data;

    private LazySingleton() {

        this.data = "Hello World";
    }
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void sayHello() {
        System.out.println(data);
    }
}
