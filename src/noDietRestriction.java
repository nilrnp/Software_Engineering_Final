import java.util.ArrayList;
public class noDietRestriction implements Diet {
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();
    @Override
    public void curate() {
        // get index of new randomly chosen carb
        int index = (int) Math.floor(Math.random() *(3 + 1));
        // get list of carbs and set the newCarb to that selected element
        String newCarb = (String) macros.getListCarbs().get(index);
        // add new carb to list
        newDiet.add(newCarb);

        // for protein
        int i = (int) Math.floor(Math.random() *(3 + 1));
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() *(3 + 1));
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);


    }

    @Override
    public void printDiet() {
        System.out.print("Diet Type: No Restriction\n");
        System.out.print("Curated Meal Contains: " + newDiet + "\n\n");
    }
}