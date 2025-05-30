package designPatterns.observer;

import designPatterns.observer.model.Magazine;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de um padrão observer para uma editora de revistas
 */
public class PublisherConcreteSubject implements PublisherSubject {
    private final List<SubscriberObserver> observers;
    private final List<Magazine> magazines;
    private Magazine latestPublication;

    public PublisherConcreteSubject() {
        this.observers = new ArrayList<>();
        this.magazines = new ArrayList<>();
    }

    @Override
    public void registerObserver(SubscriberObserver subscriber) {
        if (!observers.contains(subscriber)) {
            observers.add(subscriber);
            System.out.println("Observer registered: " + subscriber);
        }
    }

    @Override
    public void removeObserver(SubscriberObserver subscriber) {
        if(observers.remove(subscriber)){
            System.out.println("Observer removed: " + subscriber);
        }else{
            System.out.println("Observer isn't in the subscription list.");
        }
    }

    @Override
    public void notifyObservers() {
        if(latestPublication == null || latestPublication.isValid()) {
            System.out.println("Monthly edition was not published yet");
            return;
        }
        System.out.println("Monthly edition was just published, notifying observers: " + observers);
        for (SubscriberObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public String getLastPublishedMagazine() {
        return magazines.get(magazines.size()-1).getName();
    }

    public void setLatestPublication(Magazine magazine) {
        this.latestPublication = magazine;
        this.magazines.add(magazine);
        System.out.println("\nThe last edition of " +  magazine.getName() + " has been published.");
        this.notifyObservers();
    }

}
