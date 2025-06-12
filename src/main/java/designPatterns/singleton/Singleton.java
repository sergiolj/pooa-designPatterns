package designPatterns.singleton;

/**
 * Modelo proposto por Joshua Bloch no livro Java Efetivo
 */
public enum Singleton {
    INSTANCE;

    // Você pode adicionar métodos aqui
    public void doSomething() {
        System.out.println("Fazendo algo...");
    }
}
