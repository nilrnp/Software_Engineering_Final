import java.util.List;

class Restaurant extends User {
    private Menu menu;
    private List<String> operatingHours;
    private FoodType foodType;

    public Restaurant(String name, String address, String county, List<String> toppings, List<MealComponent> mealList,
            List<String> operatingHours, FoodType foodType) {
        super(name, address, county);
        this.menu = new Menu(toppings, mealList);
        this.operatingHours = operatingHours;
        this.foodType = foodType;
    }

    public List<String> getToppings() {
        return menu.getToppingList();
    }

    public List<MealComponent> getMeals() {
        return menu.getMealList();
    }

    public List<String> getOperatingHours() {
        return operatingHours;
    }

    public FoodType getCuisineType() {
        return foodType;
    }

}
