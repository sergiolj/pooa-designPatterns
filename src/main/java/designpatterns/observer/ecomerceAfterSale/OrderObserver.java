package designpatterns.observer.ecomerceAfterSale;

import designpatterns.observer.ecomerceAfterSale.model.Order;

public interface OrderObserver {
    void update(Order order);
}
