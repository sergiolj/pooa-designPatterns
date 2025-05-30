package designPatterns.observer;

public interface PublisherSubject {
    void registerObserver(SubscriberObserver subscriber);
    void removeObserver(SubscriberObserver subscriber);
    void notifyObservers();
    String getLastPublishedMagazine();
}
