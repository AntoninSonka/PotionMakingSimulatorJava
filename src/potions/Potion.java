package potions;

/**
 * Potion
 */
public class Potion {

    public int id;
    public String name;
    public String description;
    public String recepie;

    public int price;

    public Potion(int id, String name, String description, String recepie, int price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.recepie = recepie;
        this.price = price;
    }
    public int getId(){
        return this.id;
    }

}
