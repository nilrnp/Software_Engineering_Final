import java.util.List;
class Restaurant extends User {
    private List<Meal> menu;
    private List<String> operatingHours;
    private FoodType foodType;

    public Restaurant(String name, String address, String county, List<Meal> menu, List<String> operatingHours, FoodType foodType) {
        super(name, address, county);
        this.menu = menu;
        this.operatingHours = operatingHours;
        this.foodType = foodType;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public List<String> getOperatingHours() {
        return operatingHours;
    }

    public FoodType getCuisineType() {
        return foodType;
    }

}
