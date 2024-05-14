// Represents an order
import java.util.ArrayList;
import java.util.List;
class Order {
    Restaurant restaurant;
    private Customer customer;
    Driver driver;
    List<Meal> items;
    String orderCreationTime;
    String orderPickUpTime;
    String deliveredTime;

    public Order(Restaurant restaurant, Customer customer, List<Meal> items, String orderCreationTime) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.items = items;
        this.orderCreationTime = orderCreationTime;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setOrderPickUpTime(String orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }

    public void setDeliveredTime(String deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    // Other order methods
    // You can add methods for calculating total cost, modifying items, etc.
}