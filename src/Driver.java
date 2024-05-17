import java.util.ArrayList;
import java.util.List;

class Driver extends User {
    private List<String> shiftOptions = new ArrayList<>(List.of("12AM - 8AM","8AM - 4PM","4PM - 12AM"));
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
    public boolean isAvailableForOrder(int orderHour) {
        switch (shift) {
            case "12AM - 8AM":
                return orderHour >= 0 && orderHour < 8;
            case "8AM - 4PM":
                return orderHour >= 8 && orderHour < 16;
            case "4PM - 12AM":
                return orderHour >= 16 && orderHour < 24;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Driver driver1 = new Driver("Driver 1", "123 Main St", "LA County", 1);
        Driver driver2 = new Driver("Driver 2", "456 Elm St", "Orange County", 2);
        Driver driver3 = new Driver("Driver 3", "789 Oak St", "San Bernardino County", 0);

        System.out.println(driver1.getName() + " is available at 9 AM: " + driver1.isAvailableForOrder(9)); // should be true
        System.out.println(driver2.getName() + " is available at 5 PM: " + driver2.isAvailableForOrder(17)); // should be true
        System.out.println(driver3.getName() + " is available at 2 AM: " + driver3.isAvailableForOrder(2)); // should be true
    }
}
