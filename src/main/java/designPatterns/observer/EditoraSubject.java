package designPatterns.observer;

public interface EditoraSubject {
    void registerObserver(SubscriberObserver subscriber);
    void removeObserver(SubscriberObserver subscriber);
    void notifyObservers();
}
