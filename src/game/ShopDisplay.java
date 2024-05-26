package game;

import ingredients.*;

/**
 * ShopDisplay
 */
public class ShopDisplay extends Inventory {
    public ShopDisplay(){
        super();
        super.addIngredient(new Ingredient(0x00, "Eirleaf", "A plant known for its powerful healing properties", 10)); // Early game
        //super.addIngredient(new Ingredient(0x01, "Golden Flower", "A rare, sun-loving bloom with restorative effects", 25)); // Early game
        super.addIngredient(new Ingredient(0x02, "Lavender", "A fragrant herb used for calming and soothing", 8)); // Early game
        super.addIngredient(new Ingredient(0x03, "Mint", "A common herb used for refreshing and mild healing", 5)); // Early game
        super.addIngredient(new Ingredient(0x04, "Sage", "An herb used for its protective properties", 12)); // Early game
        super.addIngredient(new Ingredient(0x05, "Rosemary", "A versatile herb with various uses in potions", 10)); // Early game
        //super.addIngredient(new Ingredient(0x10, "Unicorn Hair", "Mythical hair, associated with purity and healing", 100)); // Late game
        //super.addIngredient(new Ingredient(0x11, "Phoenix Feather", "Known for its regenerative and rejuvenating properties", 120)); // Late game
        super.addIngredient(new Ingredient(0x12, "Honey", "Sweet, produced by bees, and has healing qualities", 10)); // Early game
        super.addIngredient(new Ingredient(0x13, "Bear Claw", "Symbolizes strength and ferocity, used in strength potions", 50)); // Mid game
        super.addIngredient(new Ingredient(0x14, "Snake Skin", "Shed by snakes, used for transformation potions", 45)); // Mid game
        super.addIngredient(new Ingredient(0x15, "Fish Scales", "Found near water bodies, used for various effects", 8)); // Early game
        super.addIngredient(new Ingredient(0x20, "Sunstone", "A bright mineral believed to energize and invigorate", 60)); // Mid game
        super.addIngredient(new Ingredient(0x21, "Quartz Crystal", "Used for clarity and purification in various potions", 15)); // Early game
        //super.addIngredient(new Ingredient(0x22, "Salt", "Widely available, used for purification and preservation", 5)); // Early game
        super.addIngredient(new Ingredient(0x23, "Iron Ore", "Basic metal used in strengthening potions", 10)); // Early game
        super.addIngredient(new Ingredient(0x24, "Clay", "Used for binding or grounding properties in potions", 8)); // Early game
        super.addIngredient(new Ingredient(0x30, "Spring Water", "Fresh water from natural springs, known for its purity", 5)); // Early game
        super.addIngredient(new Ingredient(0x32, "Tree Bark", "Harvested from trees, used for its grounding properties", 8)); // Early game
        super.addIngredient(new Ingredient(0x33, "Mushrooms", "Found in forests and caves, used for various effects", 10)); // Early game
        super.addIngredient(new Ingredient(0x34, "Honeycomb", "Gathered from beehives, used for sweetening and preservation", 8)); // Early game
        super.addIngredient(new Ingredient(0x31, "Fairy Dust", "Mildly magical dust collected from enchanted forests", 50)); // Mid game
        super.addIngredient(new Ingredient(0x80, "Nightshade", "A toxic plant known for its dangerous effects", 50)); // Mid game
        super.addIngredient(new Ingredient(0x81, "Withered Root", "A dried root associated with decay and poison", 15)); // Early game
        super.addIngredient(new Ingredient(0x82, "Hemlock", "A poisonous herb with a notorious reputation", 40)); // Mid game
        super.addIngredient(new Ingredient(0x90, "Spider Venom", "Extracted from spiders, used for paralysis effects", 55)); // Mid game
        super.addIngredient(new Ingredient(0x91, "Bat Wings", "Used in dark potions to cause blindness", 50)); // Mid game
        super.addIngredient(new Ingredient(0x92, "Rotten Meat", "Decayed flesh, induces weakness in potions", 5)); // Early game
        super.addIngredient(new Ingredient(0xA0, "Cursed Dust", "Found in haunted locations, used for harmful spells", 90)); // Late game
        super.addIngredient(new Ingredient(0xA1, "Obsidian Shard", "A sharp mineral linked to negative energy", 75)); // Mid game
        super.addIngredient(new Ingredient(0xB0, "Swamp Water", "Collected from stagnant swamps, often contaminated", 8)); // Early game
        super.addIngredient(new Ingredient(0xB1, "Ashes", "Remains from burnt items, associated with destruction", 20)); // Early game
        super.title = "Shop";
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
                    return (select == 3) ? 0x00 : (0x60 + select);
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
}
