package Singleton;

public class EagerSingleton {
        private static final EagerSingleton instance = new EagerSingleton();

        private EagerSingleton() {
            // Construtor privado
        }

        public static EagerSingleton getInstance() {
            return instance;
        }
}
