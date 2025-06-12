package designPatterns.singleton;

/**
 * Embora resolva o problema de Thread Safe impõe um custo de sincronização em todas as chamadas
 * à instância mesmo que isso só seja necessário uma única vez
 */
public class SingletonLazyThreadSafe {
    private static SingletonLazyThreadSafe instance;

    private SingletonLazyThreadSafe() {
    }

    public static synchronized SingletonLazyThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazyThreadSafe();
        }
        return instance;
    }
}
