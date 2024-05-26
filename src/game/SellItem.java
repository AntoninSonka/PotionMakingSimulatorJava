package game;

import graphics.*;
import utils.*;

/**
 * PotionRoom
 */
public class SellItem extends GameDisplay {
    
    public SellItem(){
        super("Sell tem", 2, 0, "[u]p + Enter, [d]own + Enter, [s]elect + Enter, [q]it + Enter");
        super.addLine("Yes");
        super.addLine("No");
        super.addLine("Sell item with 10 coins profit for potions, no profit for ingredient?");
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
                    return (select == 1) ? 0x00 : (0x70 + select);
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
