package designPatterns.singleton;

import java.time.LocalDateTime;

public class StaticBlock {
    private static final StaticBlock instance;
    private String message;

    private StaticBlock() {
        message = LocalDateTime.now().toString();
    }

    /**
     * O "metodo" static é executado apenas uma vez pela JVM quando a classe é chamada pela primeira
     * vez, isso faz com que nesse momento a instância seja criada. Esse modelo é muito semelhante ao Eager
     * Singleton, mas com a diferença de possibilitar a criação de lógica adicional na inicialização da instância
     * O Java tem um tratamento de exceção específico para esse caso que é o ExceptionInInitializerError
     * Essa talvez seja uma prática bem apropriada, pois em outros casos um erro nessa inicialização não seria notado.
     */
    static {
        try {
            instance = new StaticBlock();
        } catch (Exception e) {
           throw new ExceptionInInitializerError("Failed to initialize static block");
        }
    }
    public static StaticBlock getInstance() {
        return instance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
