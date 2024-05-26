package brewing;

import java.util.ArrayList;
import java.util.Collections;
import ingredients.*;
import potions.*;

/**
 * Pot
 */
public class Pot {
    
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public void addIngredient(Ingredient ingredient){
        if(ingredients.size() == 3){
            System.out.print("Too much ingredients, did not add any. ");
            return;
        }
        ingredients.add(ingredient);
    }
    
    public int getSize(){
        return this.ingredients.size();
    }

    public Potion stir(){ // returns potion
        if(ingredients.size() < 3){
            System.out.print("Too few ingredients. ");
            return null;
        }
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            ids.add(ingredients.get(i).id);
        }

        Collections.sort(ids);

        int potionId = (((ids.get(0) << 8) + (ids.get(1))) << 8) + ids.get(2);

        switch (potionId) { 
            case 0x001230:
                return new Potion(0x00, "Healing Potion", "Restores health and vitality.", "Eirleaf + Honey + Spring Water", 25);

            case 0x022034:
                return new Potion(0x01, "Vitality Elixir", "Boosts energy and resilience.", "Lavender + Sunstone + Honeycomb", 76);

            case 0x132332:
                return new Potion(0x02, "Strength Potion", "Increases physical strength and endurance.", "Bear Claw + Iron Ore + Tree Bark", 68);

            case 0x042330:
                return new Potion(0x03, "Endurance Draught", "Provides stamina and resilience in battle.", "Sage + Iron Ore + Spring Water", 27);

            case 0x031521:
                return new Potion(0x04, "Speed Potion", "Enhances speed and agility.", "Mint + Fish Scales + Quartz Crystal", 28);

            case 0x051520:
                return new Potion(0x05, "Nimbleness Tonic", "Heightens reflexes and agility.", "Rosemary + Fish Scales + Sunstone", 78);

            case 0x143161:
                return new Potion(0x06, "Invisibility Potion", "Grants temporary invisibility.", "Snake Skin + Fairy Dust + Obsidian Shard", 170);

            case 0x405070:
                return new Potion(0x10, "Poison Potion", "Inflicts poison on the target.", "Nightshade + Spider Venom + Swamp Water", 113);

            case 0x526070:
                return new Potion(0x11, "Toxic Mist", "Releases a cloud of poisonous gas.", "Rotten Meat + Cursed Dust + Swamp Water", 103);

            case 0x415171:
                return new Potion(0x12, "Blindness Potion", "Causes temporary blindness in the target.", "Withered Root + Bat Wings + Ashes", 85);

            case 0x316170:
                return new Potion(0x13, "Shadow Veil", "Shrouds the target in darkness, causing blindness.", "Fairy Dust + Obsidian Shard + Swamp Water", 133);

            case 0x304260:
                return new Potion(0x14, "Paralysis Potion", "Renders the target temporarily paralyzed.", "Spring Water + Hemlock + Cursed Dust", 135);

            case 0x247071:
                return new Potion(0x15, "Stiffening Serum", "Causes stiffening of muscles, rendering the target immobile.", "Clay + Swamp Water + Ashes", 36);

            case 0x313370:
                return new Potion(0x16, "Confusion Potion", "Induces confusion and disorientation in the target.", "Fairy Dust + Mushrooms + Swamp Water", 68);

            case 0x052131:
                return new Potion(0x17, "Mind Warp Elixir", "Warps the target's perception of reality, inducing confusion.", "Rosemary + Quartz Crystal + Fairy Dust", 75);

            default:
                return null;
        }
    } // WORKS!!! DO NOT TOUCH!!!
}
