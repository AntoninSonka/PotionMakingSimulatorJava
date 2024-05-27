package game;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import graphics.*;
import utils.*;

/**
 * Request
 */
public class Request extends GameDisplay {

    public int potionId = 0;

    public Request(){
        super("Request", 2, 0, "[u]p + Enter, [d]own + Enter, [s]elect + Enter, [q]it + Enter");
        super.addAsset(new Asset("../assets/requestPoster.txt", new Coords(3, 33), new Coords(25, 64)));
        super.addLine("Sell requested item");
        super.addLine("Go back");
    }
    
    public static ArrayList<String> getRequests(String path){
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public int draw() throws InterruptedException {
        while(true){
            this.textBox.select(this.select);
            String[] textImage = this.textBox.getImage();
            System.out.println(this.title);
            for(String line : this.image){
                System.out.println(line);
            }
            for(String line: textImage){
                System.out.println(line);
            }
            System.out.println(this.info);
            switch(input.normal()){
                case 1:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    return (select == 1) ? 0x00 : (0x70 + select);
                case 2:
                    select--;
                    if(select < 0){
                        select = (this.numOfDecisions - 1);
                    }
                    break;
                case 3:
                    select++;
                    if(select > (this.numOfDecisions - 1)){
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
