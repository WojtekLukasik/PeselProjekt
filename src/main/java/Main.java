import pesel.PESEL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int id = 0;


        // wyświetlanie głównego komunikatu
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Please type PESEL number which you want to save, type 0 to exit: ");
        long peselNumber = input.nextLong();
        while(peselNumber != 0){
            PESEL pesel = new PESEL(peselNumber);
            if(pesel.getLen() == 11){
                if(pesel.isValid(pesel.getDigits())){
                    // dobry pesel zapisz w strukturze danych razem z id
                    System.out.println("Typed PESEL number is valid. It will be saved in file after exit.");
                }else{
                    System.out.println("Typed PESEL number is not valid. Please try again.");
                }

            }else if (pesel.getLen() > 11){
                System.out.println("Typed PESEL number is too long. Please try again.");
            }else{
                System.out.println("Typed PESEL number is too short. Please try again.");
            }
        }


        // pętla sprawdzająca pesele
            // jeśli pesel jest poprawny zapisz do mapy razem z id

        // po zakończeniu czytania peseli zapisz je do pliku tekstowego





//        Scanner input = new Scanner(System.in);
//        System.out.println("Hello! Please type your PESEL number: ");
//        long firstPeselNumber = input.nextLong();
//        PESEL first = new PESEL(firstPeselNumber);
//        if(first.getLen() == 11){
//            if(first.isValid(first.getDigits())){
//                System.out.println("Poprawna cyfra kontrolna.");
//            } else{
//                System.out.println("Niepoprawna cyfra kontrolna.");
//            }
//
//        } else if (first.getLen() > 11){
//            System.out.println("PESEL zbyt długi. Podaj poprawny pesel");
//        } else{
//            System.out.println("Pesel zbyt krótki. Podaj poprawny pesel.");
//        }
//
//
//        System.out.println("Your PESEL number is: " + first.getPESEL());

    }
}
