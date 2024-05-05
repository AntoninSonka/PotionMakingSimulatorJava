package graphics;

import utils.*;

public class Scene {
    private String[] image = {
        "################################################################################################################################",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "################################################################################################################################"
    };
    public void addToImage(Asset asset){
        String[] str = asset.getAsset();
        Coords position = asset.getPosition();
        Coords size = asset.getSize();
        Coords start = asset.getStart();
        for(int i = start.y; i < size.y; i++){
            for(int j = start.x; j < size.x; j++){
                if(str[i].charAt(j) != 'e'){
                    this.image[i + position.y] = this.image[i + position.y].substring(0, j + position.x) + str[i].charAt(j) + this.image[i + position.y].substring(j + position.x + 1);
                }
            }
        }
    }
    public String[] getImage(){
        return this.image;
    }
}
