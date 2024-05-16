import java.util.ArrayList;

public class paleoDiet implements Diet {
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();
    // No Carbs except pistachio, No Tofu, No Dairy (Cheese and Sour cream)
    @Override
    public void curate() {
        // add new carb to list
        newDiet.add("Pistachio");

        // for protein
        int i = (int) Math.floor(Math.random() *(2 + 1));
        macros.removeProtein("Tofu");
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() *(2 + 1));
        macros.removeFat("Sour Cream");
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);
    }

    @Override
    public void printDiet() {
        System.out.print("Diet Type: Paleo\n");
        System.out.print("Curated Meal Contains: " + newDiet + "\n\n");
    }
}