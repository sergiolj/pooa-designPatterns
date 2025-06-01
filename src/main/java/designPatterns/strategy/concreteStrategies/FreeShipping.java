package designPatterns.strategy.concreteStrategies;

import designPatterns.strategy.ShipmentMethodStrategy;
import designPatterns.strategy.exceptions.FreeShippingNotApplicableException;

public class FreeShipping implements ShipmentMethodStrategy {
    private final double fixedRate = 10;


    @Override
    public double calculateShipment(double weight, double value) {
        if( weight <= 1 && value > fixedRate){
            return 0;
        }else{
            try {
                throw new FreeShippingNotApplicableException("Purchase is not available to free shipping");
            } catch (FreeShippingNotApplicableException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
