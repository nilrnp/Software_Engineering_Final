import java.util.ArrayList;
import java.util.List;
class Driver extends User {
    private List<String> shifts;
    private List<Order> orders;

    public Driver(String name, String address, String county, List<String> shifts) {
        super(name, address, county);
        this.shifts = shifts;
        this.orders = new ArrayList<>();
    }

    public List<String> getShifts() {
        return shifts;
    }

    public List<Order> getOrders() {
        return orders;
    }

}