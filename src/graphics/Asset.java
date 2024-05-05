package graphics;

import utils.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Asset{
    private String[] str;
    private Coords position;
    private Coords size;
    private Coords start;

    public Asset(String path, Coords position, Coords size){
        this.str = getAsciiArt(path);
        this.position = position;
        this.size = size;
        this.start = new Coords(0, 0);
    }

    public Asset(String path, Coords position, Coords size, Coords start){
        this.str = getAsciiArt(path);
        this.position = position;
        this.size = size;
        this.start = start;
    }

    private String[] getAsciiArt(String path){
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
        String[] linesArray = lines.toArray(new String[0]);
        return linesArray;
    }

    //getters
    
    public String[] getAsset(){
        return this.str;
    }

    public Coords getPosition(){
        return this.position;
    }

    public Coords getSize(){
        return this.size;
    }

    public Coords getStart(){
        return this.start;
    }

    //setters

    public void setPosition(Coords position){
        this.position = position;
    }

    public void setSize(Coords size){
        this.size = size;
    }

    public void setStart(Coords start){
        this.start = start;
    }
}
