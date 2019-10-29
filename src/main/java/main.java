import pesel.PESEL;
import java.util.Scanner;

public class main {
    public main(){
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Please type your PESEL number");
        int firstPeselNumber = input.nextInt();
        PESEL first = new PESEL(firstPeselNumber);
        System.out.println("Your PESEL number is: " + first.getPESEL());
    }
}
