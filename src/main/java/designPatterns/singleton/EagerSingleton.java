package designPatterns.singleton;

/**
 * Singleton ansioso eager singleton
 * Forma mais simples de criação do singleton através da inicialização quando a classe é carregada
 * pela JVM
 * Cria-se também o construtor padrão como private impedindo que novas instâncias sejam criadas
 */

public class EagerSingleton {
        private static final EagerSingleton instance = new EagerSingleton();

        private EagerSingleton() {}

        public static EagerSingleton getInstance() {
            return instance;
        }
}
