package pesel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Messages {
    private Map<String, String> messages = new HashMap<>();

    public Messages(){
        this.messages.put("Greeter", "Hello! Please type PESEL number which you want to save, type 0 to exit: ");
        this.messages.put("ValidMessage","Typed PESEL number is valid. It will be saved in file after exit.");
        this.messages.put("NotValidMessage","Typed PESEL number is not valid. Please try again.");
        this.messages.put("TooLongMessage", "Typed PESEL number is too long. Please try again.");
        this.messages.put("TooShortMessage","Typed PESEL number is too short. Please try again.");
        this.messages.put("PathMessage", "Type path of file to which numbers will be saved");
        this.messages.put("SavedMessage", "Saved PESEL numbers:");
    }

    public String get(String key){
        return this.messages.get(key);
    }


}
