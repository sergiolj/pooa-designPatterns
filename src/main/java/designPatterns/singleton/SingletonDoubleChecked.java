package designPatterns.singleton;

/**
 * Resolve o problema de thread safe e ao mesmo tempo só usa o
 * método syncronized quando realmente necessário
 */
public class SingletonDoubleChecked {
    private static SingletonDoubleChecked instance;

    private SingletonDoubleChecked() {}
    public static SingletonDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleChecked.class) {
                if (instance == null) {
                    instance = new SingletonDoubleChecked();
                }
            }
        }
        return instance;
    }
}
