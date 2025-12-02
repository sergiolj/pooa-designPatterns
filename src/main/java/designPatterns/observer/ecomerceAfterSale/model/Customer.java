package designPatterns.observer.ecomerceAfterSale.model;

public class Customer {

    public enum CommunicationMethod {
        EMAIL(1),
        SMS(2),
        WHATSAPP(3);

        private int value;

        CommunicationMethod(int value) {
            this.value = value;
        }
    }

    private final String name;
    private String address;
    private Email email;
    private String phone;

    private CommunicationMethod communicationMethod;

    public Customer(String name, String address, Email email, String phone, CommunicationMethod method) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.communicationMethod = method;
    }

    public Customer(String name, Email email){
        this(name,null, email,null,CommunicationMethod.EMAIL);
    }

    public Customer(String name, String phone){
        this(name,null,null,phone, null);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Email getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public CommunicationMethod getCommunicationMethod() {
        return this.communicationMethod;
    }

    public void setCommunicationMethod(CommunicationMethod communicationMethod) {
        this.communicationMethod = communicationMethod;
    }
}
