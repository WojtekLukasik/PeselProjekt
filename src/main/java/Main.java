import pesel.FileSaver;
import pesel.PESEL;
import pesel.Messages;

import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        //TreeMap<Integer, Long> validPesels = new TreeMap<Integer, Long>();
        List<Long> validPessels = new ArrayList<>();
        Messages messages = new Messages();

        // wyświetlanie głównego komunikatu oraz pobieranie pierwszego numeru
        System.out.println(messages.get("Greeter"));
        long peselNumber = getNumber();

        // główna pętla programu
        while(peselNumber != 0){
            PESEL pesel = new PESEL(peselNumber);
            if(pesel.getLen() == 11){
                if(pesel.isValid(pesel.getDigits())){
                    // dobry pesel zapisz w strukturze danych razem z id
                    System.out.println(messages.get("ValidMessage"));
                    validPessels.add(pesel.getPESEL());
                }else{
                    System.out.println(messages.get("NotValidMessage"));
                }

            }else if (pesel.getLen() > 11){
                System.out.println(messages.get("TooLongMessage"));
            }else{
                System.out.println(messages.get("TooShortMessage"));
            }

            // pobierz kolejny numer
            peselNumber = getNumber();
        }
        // po zakończeniu czytania peseli zapisz je do pliku tekstowego
        System.out.println(messages.get("PathMessage"));
        Scanner scanner = new Scanner(System.in);
        String data = new String();
        String tokens[] = scanner.nextLine().split(" ");
        FileSaver fileSaver = new FileSaver(tokens[0]);
        for(Long pesel: validPessels){
            data += pesel.toString() + "\n";
            //fileSaver.Write(pesel.toString());
        }
        fileSaver.Write(data);

        // wypisz poprawne pesele
        System.out.println(messages.get("SavedMessage"));
        validPessels.stream()
                .forEach(y -> System.out.println(y));

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
