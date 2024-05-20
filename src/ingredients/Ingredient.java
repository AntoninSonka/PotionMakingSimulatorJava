package ingredients;

/**
 * Ingredient
 */
public class Ingredient {

    int id;
    String name;
    String description;

    int quality;
    int health; // 0 - neutral, signed - poison, unsigned - health potion
    
    public Ingredient(){
        
    }
}
