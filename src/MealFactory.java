
// Factory Pattern
class MealFactory {
    public static MealComponent createMeal(String dietPlan) {
        switch (dietPlan) {
            case "noRestriction":
                return new noDietRestriction("No Restriction Meal");
            case "vegan":
                return new veganDiet("Vegan Meal");
            case "poleo":
                return new paleoDiet("Paleo Meal");
            case "nutAllergy":
                return new nutAllergyDiet("Nut Allergy Meal");
            default:
                return new noDietRestriction("No Restriction Meal");
        }

    }
}