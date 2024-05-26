package graphics;

public class TextBox {
    private String[] image = {    
        "################################################################################################################################",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "#                                                                                                                              #",
        "################################################################################################################################"
    };
    private int numOfDecisions = 0;
    
    // 0 numOfDecisions - only text
    public TextBox(int numOfDecisions, String[] lines){
        this.numOfDecisions = numOfDecisions;
        for(int i = 0; i < lines.length; i++){
            if(numOfDecisions > 0){
                this.image[i + 1] = this.image[i + 1].substring(0, 2) + "[ ] " + lines[i] + this.image[i + 1].substring(lines[i].length() + 6);
                numOfDecisions--;
            }
            else{
                this.image[i + 1] = this.image[i + 1].substring(0, 2) + lines[i] + this.image[i + 1].substring(lines[i].length() + 2); 
            }
        }
    }
    public void select(int selected){
        for(int i = 0; i < this.numOfDecisions; i++){
            if(i == selected){
                this.image[i + 1] = this.image[i + 1].substring(0, 3) + "*" + this.image[i + 1].substring(4);
            }
            else{
                this.image[i + 1] = this.image[i + 1].substring(0, 3) + " " + this.image[i + 1].substring(4);
            }
        }
    }
    public String[] getImage(){
        return this.image;
    }
}
