package designPatterns.strategy.exceptions;

public class FreeShippingNotApplicableException extends RuntimeException {
    public FreeShippingNotApplicableException(String message) {
        super(message);
    }
}
