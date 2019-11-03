package pesel;
import java.util.List;
import java.util.stream.Stream;

public class PESEL {

    private long peselNumber;

    public PESEL(long peselNumber){
        this.peselNumber = peselNumber;
    }

    public long getPESEL(){
        return peselNumber;
    }

    public int[] getDigits(){
        int[] digits = new int[12];
        int i=10, length = 0;
        long peselNumber = this.peselNumber;
        while(length <= 10){
            digits[i] = Math.toIntExact(peselNumber % 10);
            peselNumber = peselNumber / 10;
            i--;
            length++;
        }
        return digits;
    }

    public int getLen(){
        int length = 0;
        long check = this.peselNumber;
        while(check > 0){
            check = check / 10;
            length++;
        }
        return length;
    }

    public boolean isValid(int[] digits){
         int a = digits[0], b = digits[1], c = digits[2], d = digits[3], e = digits[4], f = digits[5], g = digits[6],
                 h = digits[7], i = digits[8], j = digits[9], controlDigit = digits[10];
         int number = (9 * a + 7 * b + 3 * c + d + 9 * e + 7 * f + 3 * g + h + 9 * i + 7 * j) % 10;
        return number == controlDigit;
    }
}
