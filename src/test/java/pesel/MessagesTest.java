package pesel;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

class MessagesTest {

    private Messages messages = new Messages();

    @Test
    void get() {
        assertSame("Hello! Please type PESEL number which you want to save, type 0 to exit: ", messages.get("Greeter"));
        assertSame("Typed PESEL number is valid. It will be saved in file after exit.", messages.get("ValidMessage"));
        assertSame("Typed PESEL number is not valid. Please try again.", messages.get("NotValidMessage"));
        assertSame("Typed PESEL number is too long. Please try again.", messages.get("TooLongMessage"));
        assertSame("Typed PESEL number is too short. Please try again.", messages.get("TooShortMessage"));
        assertSame("Type path of file to which numbers will be saved", messages.get("PathMessage"));
        assertSame("Saved PESEL numbers:", messages.get("SavedMessage"));
    }
}