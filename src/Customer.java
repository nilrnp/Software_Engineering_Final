import java.util.ArrayList;
import java.util.List;

class Customer extends User {
    private List<Order> orders;
    private List<String> dietaryRestrictions;

    public Customer(String name, String address, String county) {
        super(name, address, county);
        this.orders = new ArrayList<>();
        this.dietaryRestrictions = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

}