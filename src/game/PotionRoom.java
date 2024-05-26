package game;

import graphics.*;
import utils.*;

/**
 * PotionRoom
 */
public class PotionRoom extends GameDisplay {
    
    public PotionRoom(){
        super("Brewomg Room", 4, 0, "[u]p + Enter, [d]own + Enter, [s]elect + Enter, [q]it + Enter");
        super.addAsset(new Asset("../assets/pot.txt", new Coords(17, 52), new Coords(14, 24)));
        super.addAsset(new Asset("../assets/shelf.txt", new Coords(7, 87), new Coords(14, 40)));
        super.addAsset(new Asset("../assets/scale.txt", new Coords(19, 3), new Coords(12, 16)));
        super.addAsset(new Asset("../assets/grinder.txt", new Coords(21, 27), new Coords(10, 13)));
        super.addLine("Pot");
        super.addLine("Shelf");
        super.addLine("Shop");
        super.addLine("Requests");
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
                    return 0x10 + select;
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
