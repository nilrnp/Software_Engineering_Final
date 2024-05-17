import java.util.ArrayList;
import java.util.List;

class Driver extends User {
    private List<String> shiftOptions = new ArrayList<>(List.of("12:00AM - 8:00AM","8:00AM - 4:00PM","4:00PM - 12:00AM"));
    private String shift;
    private List<Order> orders;

    public Driver(String name, String address, String county, int shift) {
        super(name, address, county);
        this.shift = shiftOptions.get(shift);
        this.orders = new ArrayList<>();
    }

    public String getShift() {

        return shift;
    }

    public List<Order> getOrders() {

        return orders;
    }

}
