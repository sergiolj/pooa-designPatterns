package designPatterns.observer;

public class SubscriberConcreteObserver implements SubscriberObserver{
    private String name;
    private final PublisherSubject publisher;

    public SubscriberConcreteObserver(String name, PublisherSubject publisher) {
        this.name = name;
        this.publisher = publisher;
        this.publisher.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("\nSubscriber " + this.name + " was informed by Email that the latest edition of "
                + this.publisher.getLastPublishedMagazine() + " magazine has been released.");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
