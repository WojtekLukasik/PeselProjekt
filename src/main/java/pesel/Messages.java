package pesel;

import java.util.ArrayList;

public class Messages {
    private ArrayList<String> messages = new ArrayList<String>();

    public Messages(){
        this.messages.add("Hello! Please type PESEL number which you want to save, type 0 to exit: ");
        this.messages.add("Typed PESEL number is valid. It will be saved in file after exit.");
        this.messages.add("Typed PESEL number is not valid. Please try again.");
        this.messages.add("Typed PESEL number is too long. Please try again.");
        this.messages.add("Typed PESEL number is too short. Please try again.");
    }

    public String get(int index){
        return this.messages.get(index);
    }


}
