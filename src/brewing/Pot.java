package brewing;
import java.util.ArrayList;
import ingredients.*;

/**
 * Pot
 */
public class Pot {
    
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public int stir(){ // returns potions id
        
        return 0;
    }
}
