import game.*;
import brewing.*;
import potions.*;
import java.util.ArrayList;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        int choice = 0x00;
        int ingredientIndex = 0;
        int potionIndex = 0;
        int shopIndex = 0;
        ArrayList<String> requestList = Request.getRequests("../assets/requests.txt");
        int requestListIndex = 0;
        Inventory inventory = new Inventory();
        inventory.setMoney(25);
        ShopDisplay shop = new ShopDisplay();
        while(choice != -1){
            if(choice == 0x00){
                PotionRoom brewing = new PotionRoom();
                try{
                    choice = brewing.draw();
                }
                catch(InterruptedException e){
                    System.err.print("i dont fucking know. ");
                    e.printStackTrace();
                }
            }
            else if(choice == 0x10){
                PotDisplay potDisplay = new PotDisplay();
                try{
                    Pot pot = new Pot();
                    boolean condition = true;
                    while(condition){
                        if(choice == 0x10)
                            choice = potDisplay.draw();
                        if(choice == 0x40){
                            if(inventory.getIngredientCount() == 0){
                                System.out.print("No ingredients to show. ");
                                choice = 0x10;
                            }
                            else{
                                try{
                                    inventory.setup(ingredientIndex, true);
                                    choice = inventory.draw();
                                    if(choice == 0x30){
                                        pot.addIngredient(inventory.getIngredient(ingredientIndex));
                                        inventory.removeIngredient(ingredientIndex);
                                        ingredientIndex = 0;
                                        potionIndex = 0;
                                        choice = 0x10;
                                    }
                                    else if(choice == 0x31){
                                        choice = 0x40;
                                        ingredientIndex--;
                                        if(ingredientIndex < 0){
                                            ingredientIndex = (inventory.getIngredientCount() - 1);
                                        }
                                    }
                                    else if(choice == 0x32){
                                        choice = 0x40;
                                        ingredientIndex++;
                                        if(ingredientIndex >= inventory.getIngredientCount()){
                                            ingredientIndex = 0;
                                        }
                                    }
                                    else if(choice == 0x11){
                                        choice = 0x10;
                                    }
                                }
                                catch(InterruptedException e){
                                    System.err.println("i dont fucking know");
                                    e.printStackTrace();
                                }
                            }
                        }
                        else if(choice == 0x41){
                            Potion potion = pot.stir();
                            if(potion == null){
                                System.out.print("This wasn\'t a correct combination. ");
                            }
                            else {
                                System.out.print("You made " + potion.name + ". ");
                                inventory.addPotion(potion);
                            }
                            choice = 0x10;
                            condition = false;
                        }
                        else if(choice == 0x42){
                            choice = 0x00;
                            condition = false;
                        }
                    }
                }
                catch(InterruptedException e){
                    System.err.println("i dont fucking know");
                    e.printStackTrace();
                }
                choice = 0x00;
            }
            else if(choice == 0x11){
                ShelfDisplay shelf = new ShelfDisplay();
                try{
                    choice = shelf.draw();
                }
                catch(InterruptedException e){
                    System.err.println("i dont fucking know");
                    e.printStackTrace();
                }
            }
            else if(choice == 0x20){
                if(inventory.getIngredientCount() == 0){
                    System.out.print("No ingredients to show. ");
                    choice = 0x11;
                }
                else{
                    try{
                        inventory.setup(ingredientIndex, true);
                        choice = inventory.draw();
                        if(choice == 0x30){
                            SellItem sell = new SellItem();
                            choice = sell.draw();
                            if(choice == 0x70){
                                inventory.setMoney(inventory.getMoney() + inventory.getIngredient(ingredientIndex).price);
                                inventory.removeIngredient(ingredientIndex);
                            }
                            ingredientIndex = 0;
                            potionIndex = 0;
                            choice = 0x00;
                        }
                        else if(choice == 0x31){
                            choice = 0x20;
                            ingredientIndex--;
                            if(ingredientIndex < 0){
                                ingredientIndex = (inventory.getIngredientCount() - 1);
                            }
                        }
                        else if(choice == 0x32){
                            choice = 0x20;
                            ingredientIndex++;
                            if(ingredientIndex >= inventory.getIngredientCount()){
                                ingredientIndex = 0;
                            }
                        }
                    }
                    catch(InterruptedException e){
                        System.err.println("i dont fucking know");
                        e.printStackTrace();
                    }
                }
            }
            else if(choice == 0x21){
                if(inventory.getPotionCount() == 0){
                    System.out.print("No potions to show. ");
                    choice = 0x11;
                }
                else{
                    try{
                        inventory.setup(potionIndex, false);
                        choice = inventory.draw();
                        if(choice == 0x30){
                            SellItem sell = new SellItem();
                            choice = sell.draw();
                            if(choice == 0x70){
                                inventory.setMoney(inventory.getMoney() + inventory.getPotion(potionIndex).price + 10);
                                inventory.removePotion(potionIndex);
                            }
                            ingredientIndex = 0;
                            potionIndex = 0;
                            choice = 0x00;
                        }
                        else if(choice == 0x31){
                            choice = 0x21;
                            potionIndex--;
                            if(potionIndex < 0){
                                potionIndex = (inventory.getPotionCount() - 1);
                            }
                        }
                        else if(choice == 0x32){
                            choice = 0x21;
                            potionIndex++;
                            if(potionIndex >= inventory.getPotionCount()){
                                potionIndex = 0;
                            }
                        }
                    }
                    catch(InterruptedException e){
                        System.err.println("i dont fucking know");
                        e.printStackTrace();
                    }
                }
            }
            else if(choice == 0x22){
                System.out.print(inventory.getMoney() + ". ");
                choice = 0x11;
            }
            else if(choice == 0x12){
                try{
                    shop.setup(shopIndex, true);
                    choice = shop.draw();
                    if(choice == 0x00){
                        shopIndex = 0;
                    }
                    else if(choice == 0x60){
                        if(inventory.getMoney() < shop.getIngredient(shopIndex).price){
                            System.out.print("Not enough money. ");
                        }
                        else{
                            System.out.print("Item bought. ");
                            inventory.setMoney(inventory.getMoney() - shop.getIngredient(shopIndex).price);
                            inventory.addIngredient(shop.getIngredient(shopIndex));
                        }
                        choice = 0x12;
                    }
                    else if(choice == 0x61){
                        choice = 0x12;
                        shopIndex--;
                        if(shopIndex < 0){
                            shopIndex = (shop.getIngredientCount() - 1);
                        }
                    }
                    else if(choice == 0x62){
                        choice = 0x12;
                        shopIndex++;
                        if(shopIndex >= shop.getIngredientCount()){
                            shopIndex = 0;
                        }
                    }
                }
                catch(InterruptedException e){
                    System.err.println("i dont fucking know");
                    e.printStackTrace();
                }
            }
            else if(choice == 0x13){
                Request request = new Request();
                if((requestListIndex) == requestList.size()){
                    System.out.print("You won. It wasnt much, but hey, pretty okay, right? ");
                    choice = 0x00;
                }
                else{
                    try{
                        request.potionId = Integer.parseInt(requestList.get(requestListIndex));
                    }
                    catch (NumberFormatException ex){
                        ex.printStackTrace();
                    }
                    requestListIndex++;
                    request.addLine(requestList.get(requestListIndex));
                    requestListIndex++;
                    request.addLine(requestList.get(requestListIndex));
                    requestListIndex++;
                    request.addLine("");
                    request.addLine(requestList.get(requestListIndex));
                    requestListIndex++;
                    request.setup();
                    try{
                        choice = request.draw();
                        if(choice == 0x70){
                            boolean hasBeenSold = false;
                            for(int i = 0; i < inventory.getPotionCount(); i++){
                                if(request.potionId == inventory.getPotion(i).id){
                                    inventory.setMoney(inventory.getMoney() + inventory.getPotion(i).price + 60);
                                    inventory.removePotion(i);
                                    System.out.print("Potion sold. ");
                                    hasBeenSold = true;
                                    break;
                                }
                            }
                            if(!hasBeenSold){
                                System.out.print("You don\'t have requested potion. ");
                                requestListIndex -= 4;
                            }
                            choice = 0x13;
                        }
                        else if(choice == 0x00){
                            requestListIndex -= 4;
                        }
                    }
                    catch(InterruptedException e){
                        System.err.println("i dont fucking know");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
