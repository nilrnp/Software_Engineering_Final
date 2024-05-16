import java.util.ArrayList;
public class veganDiet implements Diet{
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();
    // No Meat (Fish, Chicken, Tuna) and No Dairy (Cheese and Sour cream)
    @Override
    public void curate() {
        // add new carb to list
        int index = (int) Math.floor(Math.random() *(2 + 1));
        // no cheese
        macros.removeCarb("Cheese");
        String newCarb = (String) macros.getListCarbs().get(index);
        newDiet.add(newCarb);

        // for protein
        int i = (int) Math.floor(Math.random() *(1 + 1));
        // no fish or chicken
        macros.removeProtein("Fish");
        macros.removeProtein("Chicken");
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() *(1 + 1));
        // no sour cream or tuna
        macros.removeFat("Sour Cream");
        macros.removeFat("Tuna");
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);
    }

    @Override
    public void printDiet() {
        System.out.print("Diet Type: Vegan\n");
        System.out.print("Curated Meal Contains: " + newDiet + "\n\n");
    }
}