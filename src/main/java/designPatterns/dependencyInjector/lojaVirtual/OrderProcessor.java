package designPatterns.dependencyInjector.lojaVirtual;

class OrderProcessor {
    private final NotificationService notifyService;

    public OrderProcessor(NotificationService notifyService) {
        this.notifyService = notifyService;
    }

    public void processOrder(Order order) {
        this.notifyService.sendNotification(order);
    }
}
