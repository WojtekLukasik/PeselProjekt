import pesel.PESEL;
import pesel.Messages;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        int id = 0;
        TreeMap<Integer, Long> validPesels = new TreeMap<Integer, Long>();
        Messages messages = new Messages();

        // wyświetlanie głównego komunikatu oraz pobieranie pierwszego numeru
        System.out.println(messages.get(0));
        long peselNumber = getNumber();

        // główna pętla programu
        while(peselNumber != 0){
            PESEL pesel = new PESEL(peselNumber);
            if(pesel.getLen() == 11){
                if(pesel.isValid(pesel.getDigits())){
                    // dobry pesel zapisz w strukturze danych razem z id
                    System.out.println(messages.get(1));
                    validPesels.put(++id, pesel.getPESEL());
                }else{
                    System.out.println(messages.get(2));
                }

            }else if (pesel.getLen() > 11){
                System.out.println(messages.get(3));
            }else{
                System.out.println(messages.get(4));
            }

            // pobierz kolejny numer
            peselNumber = getNumber();
        }
        System.out.println("Zapisane numery PESEL: ");

        validPesels.stream()



        // po zakończeniu czytania peseli zapisz je do pliku tekstowego

    }

    // metoda do wyłapywania niepoprawności we wpisywanych danych
    // wpisanie czegokolwiek innego niż cyfry nie wysypuje całego programu
    public static long getNumber(){
        Scanner input = new Scanner(System.in);
        try{
            return input.nextLong();
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
            return 1;
        }
    }
}
