package designPatterns.observer.ecomerceAfterSale;

import designPatterns.observer.ecomerceAfterSale.model.Order;

public interface OrderObserver {
    void update(Order order);
}
