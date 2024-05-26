package game;

import graphics.*;
import controll.*;
import java.util.ArrayList;

/**
 * GameDisplay
 */
public class GameDisplay {
    
    protected Scene scene;
    protected InputHandle input;
    protected TextBox textBox;
    protected ArrayList<String> text;

    protected String title;
    protected int numOfDecisions;
    protected int select;
    protected String info;
    protected String[] image;

    public GameDisplay(){
        this.title = "";
        this.numOfDecisions = 0;
        this.select = 0;
        this.info = "";
        this.scene = new Scene();
        this.input = new InputHandle();
        this.text = new ArrayList<String>();
    }

    public GameDisplay(String title, int numOfDecisions, int select, String info){
        this.title = title;
        this.numOfDecisions = numOfDecisions;
        this.select = select;
        this.info = info;
        this.scene = new Scene();
        this.input = new InputHandle();
        this.text = new ArrayList<String>();
    }

    public void addAsset(Asset asset){
        this.scene.addToImage(asset);
    }

    public void addLine(String line){
        text.add(line);
    }

    public void setup(){
        String[] textArr = {"", "", "", "", "", ""};
        for(int i = 0; i < 6; i++){
            if(i < this.text.size()){
                textArr[i] = this.text.get(i);
            }
        }
        this.textBox = new TextBox(this.numOfDecisions, textArr);
        this.image = this.scene.getImage();
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
                    return select;
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
