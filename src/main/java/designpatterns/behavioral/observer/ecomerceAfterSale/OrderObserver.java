package designpatterns.behavioral.observer.ecomerceAfterSale;

import designpatterns.behavioral.observer.ecomerceAfterSale.model.Order;

public interface OrderObserver {
    void update(Order order);
}
