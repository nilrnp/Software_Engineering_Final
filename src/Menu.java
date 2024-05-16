import java.util.List;

public class Menu {
    private List<String> toppingList;
    private List<String> mealList = List.of("No Restriction Meal", "Vegan Meal", "Paleo Meal", "Nut Allergy Meal");

    public Menu(List<String> toppingList) {
        this.toppingList = toppingList;
    }

    public List<String> getToppingList() {
        return toppingList;
    }

    public List<String> getMealList() {
        return mealList;
    }

}
