// Factory Pattern
import java.util.List;
class MealFactory {
    public static Meal createMeal(String name, int fats, int carbs, int protein) {
        return new Meal(name, fats, carbs, protein);
    }
}