package ingredients;

/**
 * Ingredient
 */
public class Ingredient {

    public int id;
    public String name;
    public String description;

    public int price;
    
    public Ingredient(int id, String name, String description, int price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public int getId(){
        return this.id;
    }
}
