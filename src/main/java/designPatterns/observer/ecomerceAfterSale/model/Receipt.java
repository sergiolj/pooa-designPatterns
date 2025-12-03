package designPatterns.observer.ecomerceAfterSale.model;

import java.util.HashMap;
import java.util.Map;

public class Receipt {

    private Map<String, Double> productList;
    private final Customer customer;

    public Receipt(Customer customer) {
        productList = new HashMap<String, Double>();
        this.customer = customer;
    }

    public Map<String, Double> getProductList() {
        return productList;
    }
    public void addProductToList(String product, double price) {
        productList.put(product, price);
    }

    public void removeProductFromList(String product) {
        productList.remove(product);
    }

    public Customer getCustomer() {
        return customer;
    }
}
