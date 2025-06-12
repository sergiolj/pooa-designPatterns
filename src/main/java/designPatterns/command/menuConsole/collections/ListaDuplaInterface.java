package designPatterns.command.menuConsole.collections;

public interface ListaDuplaInterface <T>{
    boolean adicionarInicio(T elemento);
    boolean adicionarFim(T elemento);
    boolean removerFim();
    boolean removerInicio();
    int length();
    boolean contains(T elemento);
    T get(int index);
    void clear();
}
