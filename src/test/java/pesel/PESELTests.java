package pesel;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class PESELTests {

    private PESEL peselOne = new PESEL(99051208635L); // poprawny numer
    private PESEL peselTwo = new PESEL(99051208630L); // błędny numer

    @Test
    void getPESEL() {
        long peselGetTest = peselOne.getPESEL();
        assertTrue(peselGetTest == 99051208635L);
    }

    @Test
    void getDigits() {
        int[] peselGetDigitsTest = peselOne.getDigits();
        int[] testDigits = new int [11];
        testDigits[0] = 9;
        testDigits[1] = 9;
        testDigits[2] = 0;
        testDigits[3] = 5;
        testDigits[4] = 1;
        testDigits[5] = 2;
        testDigits[6] = 0;
        testDigits[7] = 8;
        testDigits[8] = 6;
        testDigits[9] = 3;
        testDigits[10] = 5;
        //[9, 9, 0, 5, 1, 2, 0, 8, 6, 3, 5];
        assertTrue(Arrays.equals(peselGetDigitsTest,testDigits));
    }

    @Test
    void getLen() {
        int peselGetLenTest = peselOne.getLen();
        assertTrue(peselGetLenTest == 11);
    }

    @Test
    void isValid() {
        assertTrue("Ten pesel jest poprawny", peselOne.isValid(peselOne.getDigits()));
        assertFalse("Ten pesel jest niepoprawny", peselTwo.isValid(peselTwo.getDigits()));
    }
}