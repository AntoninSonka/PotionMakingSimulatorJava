package game;

import graphics.*;
import utils.*;

/**
 * PotDisplay
 */
public class PotDisplay extends GameDisplay {
    
    public PotDisplay(){
        super("Pot", 3, 0, "[u]p + Enter, [d]own + Enter, [s]elect + Enter, [q]it + Enter");
        super.addAsset(new Asset("../assets/pot.txt", new Coords(17, 52), new Coords(14, 24)));
        super.addLine("Ingredients");
        super.addLine("Stir");
        super.addLine("Go back");
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
                    return (0x40 + select);
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
