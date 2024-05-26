package game;

import potions.*;
import ingredients.*;
import graphics.*;
import utils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Inventory
 */
public class Inventory extends GameDisplay {
    protected ArrayList<Ingredient> ingredientInventory;
    protected ArrayList<Potion> potionInventory;
    private int money = 0;
    protected int ingredientCount = 0;
    protected int potionCount = 0;

    public Inventory(){
        super("Inventory", 4, 0, "[u]p + Enter, [d]own + Enter, [s]elect + Enter, [q]it + Enter");
        this.ingredientInventory = new ArrayList<Ingredient>();
        this.potionInventory = new ArrayList<Potion>();
        super.addAsset(new Asset("../assets/blank.txt", new Coords(0, 0), new Coords(0, 0)));
    }

    public void setup(int index, boolean isIngredient){
        for(int i = super.text.size() - 1; i >= 0; i--){
            super.text.remove(i);
        }
        if(isIngredient)
            super.addLine(ingredientInventory.get(index).name);
        else
            super.addLine(potionInventory.get(index).name);
        super.addLine("Previous");
        super.addLine("Next");
        super.addLine("Go back");
        if(isIngredient)
            super.addLine(ingredientInventory.get(index).description);
        else
            super.addLine(potionInventory.get(index).description);
        if(isIngredient)
            super.addLine("price: " + ingredientInventory.get(index).price);
        else
            super.addLine(potionInventory.get(index).recepie + ", price: " + potionInventory.get(index).price);
        super.setup();
    }

    public int draw() throws InterruptedException {
        while(true){
            super.textBox.select(super.select);
            String[] textImage = super.textBox.getImage();
            System.out.println(super.title);
            for(String line : super.image){
                System.out.println(line);
            }
            for(String line: textImage){
                System.out.println(line);
            }
            System.out.println(super.info);
            switch(input.normal()){
                case 1:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    return (select == 3) ? 0x11 : (0x30 + select);
                case 2:
                    select--;
                    if(select < 0){
                        select = (super.numOfDecisions - 1);
                    }
                    break;
                case 3:
                    select++;
                    if(select > (super.numOfDecisions - 1)){
                        select = 0;
                    }
                    break;
                case 4:
                    return -1;
                default:
                    System.out.println("Not an option, try again");
                    Thread.sleep(1000);
                    break;
            }
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }
    }

    public void addIngredient(Ingredient ingredient){
        ingredientCount++;
        this.ingredientInventory.add(ingredient);
        Collections.sort(this.ingredientInventory, new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient o1, Ingredient o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
    }

    public Ingredient getIngredient(int index){
        return ingredientInventory.get(index);
    }

    public void removeIngredient(int index){
        ingredientCount--;
        ingredientInventory.remove(index);
    }

    public int getIngredientCount(){
        return ingredientCount;
    }

    public void addPotion(Potion potion){
        potionCount++;
        this.potionInventory.add(potion);
        Collections.sort(this.potionInventory, new Comparator<Potion>() {
            @Override
            public int compare(Potion o1, Potion o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
    }

    public Potion getPotion(int index){
        return potionInventory.get(index);
    }

    public void removePotion(int index){
        potionCount--;
        potionInventory.remove(index);
    }

    public int getPotionCount(){
        return potionCount;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return this.money;
    }
}
