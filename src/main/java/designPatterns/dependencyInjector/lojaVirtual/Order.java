package designPatterns.dependencyInjector.lojaVirtual;

import designPatterns.dependencyInjector.lojaVirtual.util.*;

public class Order {
    private final String orderId;
    private OrderStatus status;
    private final String SMS;
    private final String EMAIL;
    private final MessageMethod preferredNotification;

    public Order(String orderId, String SMS, String EMAIL, MessageMethod preferredNotification) {
        this.orderId = orderId;
        this.status = OrderStatus.RECEIVED;
        this.SMS = SMS;
        this.EMAIL = EMAIL;
        this.preferredNotification = preferredNotification;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getPreferredNotification() {
        if (preferredNotification != null) {
            if (preferredNotification == MessageMethod.SMS) {
                return this.SMS;
            } else if (preferredNotification == MessageMethod.EMAIL) {
                return this.EMAIL;
            }
        }
        throw new IllegalArgumentException("Invalid Message Notification Method");
    }

    public String messageStatus() {
        String msgStatus = this.status.name();
        if(msgStatus.equals(OrderStatus.WAITING_PAYMENT.name())) {
            return "Order waiting payment confirmation";
        }else if(msgStatus.equalsIgnoreCase(OrderStatus.SENDING.name())) {
            return "Package in transit";
        }else if(msgStatus.equalsIgnoreCase(OrderStatus.SENT.name())) {
            return "You had received you purchase, enjoy it!";
        }else if(msgStatus.equalsIgnoreCase(OrderStatus.RECEIVED.name())) {
            return "Thanks for buying with us, please stand by while we are processing your order!.";
        }
        return msgStatus;
    }

    public String getSMS() {
        return SMS;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
