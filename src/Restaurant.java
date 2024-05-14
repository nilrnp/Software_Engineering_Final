// Represents a restaurant
import java.util.ArrayList;
import java.util.List;
class Restaurant extends User {
    private List<Meal> menu;
    private List<String> operatingHours;
    private CuisineType cuisineType;

    public Restaurant(String name, String address, String county, List<Meal> menu, List<String> operatingHours, CuisineType cuisineType) {
        super(name, address, county);
        this.menu = menu;
        this.operatingHours = operatingHours;
        this.cuisineType = cuisineType;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public List<String> getOperatingHours() {
        return operatingHours;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    // Other restaurant methods
    // You can add methods for adding/removing items from the menu, checking operating hours, etc.
}
