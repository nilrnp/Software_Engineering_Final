import java.util.ArrayList;
import java.util.List;

class Driver extends User {
    private ShiftType shift;
    private List<Order> orders;

    public Driver(String name, String address, String county, ShiftType shift) {
        super(name, address, county);
        this.shift = shift;
        this.orders = new ArrayList<>();
    }

    public ShiftType getShift() {
        return shift;
    }

    public List<Order> getOrders() {
        return orders;
    }

}