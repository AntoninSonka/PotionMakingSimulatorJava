package controll;

import java.util.Scanner;

public class InputHandle {
    private Scanner input;

    public InputHandle(){
        this.input = new Scanner(System.in);
    }

    public int normal(){
        while(true){
            String str = this.input.nextLine();
            switch (str) {
                case "c":
                    return 0;
                case "s":
                    return 1;
                case "u":
                    return 2;
                case "d":
                    return 3;
                default:
                    System.out.println("Couldn\'t resolve the input. Please try again.");
                    break;
            }
        }
    }
}
