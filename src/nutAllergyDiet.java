import java.util.ArrayList;

public class nutAllergyDiet implements Diet {
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();
    // No Nuts (Pistachio and Peanuts)
    @Override
    public void curate() {
        // add new carb to list
        int index = (int) Math.floor(Math.random() *(2 + 1));
        // no pistachio
        macros.removeCarb("Pistachio");
        String newCarb = (String) macros.getListCarbs().get(index);
        newDiet.add(newCarb);

        // for protein
        int i = (int) Math.floor(Math.random() *(3 + 1));
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() *(2 + 1));
        // no peanuts
        macros.removeFat("Peanuts");
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);
    }

    @Override
    public void printDiet() {
        System.out.print("Diet Type: Nut Allergy\n");
        System.out.print("Curated Meal Contains: " + newDiet + "\n\n");
    }
}