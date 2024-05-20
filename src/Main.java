import graphics.*;
import utils.*;
import controll.*;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) 
        throws InterruptedException {
        // Asset witch = new Asset("../assets/witch1.txt", new Coords(13, 10), new Coords(19, 23), new Coords(0, 0));
        Asset cauldron = new Asset("../assets/cauldron.txt", new Coords(17, 52), new Coords(14, 24));
        Asset shelf = new Asset("../assets/shelf.txt", new Coords(7, 87), new Coords(14, 40));
        Asset scale = new Asset("../assets/scale.txt", new Coords(19, 3), new Coords(12, 16));
        Scene render = new Scene();
        render.addToImage(cauldron);
        render.addToImage(shelf);
        render.addToImage(scale);
        String[] image = render.getImage();
        String[] text = {
            "hello, hello, hello",
            "idk idk idk",
            "hovado hovado hovado",
            "hallo, hallo, hallo",
            "idc idc idc",
            "hovada hovada hovada"
        };
        TextBox textBox = new TextBox(4, text);
        InputHandle input = new InputHandle();
        
        int select = 0;

        while(true){
            textBox.select(select);
            String[] textImage = textBox.getImage();
            for(String line : image){
                System.out.println(line);
            }
            for(String line: textImage){
                System.out.println(line);
            }
            System.out.println("[u]p + Enter, [d]own + Enter, [s]elect + Enter");
            switch(input.normal()){
                case 1:
                    return;
                case 2:
                    select--;
                    if(select < 0){
                        select = 3;
                    }
                    break;
                case 3:
                    select++;
                    if(select > 3){
                        select = 0;
                    }
                    break;
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
