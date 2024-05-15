// Observer Pattern
import java.util.List;
class Order {
    Restaurant restaurant;
    Customer customer;
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

    public List<Meal> getItems() {
        return items;
    }
}