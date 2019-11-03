import pesel.Saver;
import pesel.PESEL;
import pesel.Messages;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        //TreeMap<Integer, Long> validPesels = new TreeMap<Integer, Long>();
        List<PESEL> pessels = new ArrayList<>();
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
                    pessels.add(pesel);
                }else{
                    System.out.println(messages.get("NotValidMessage"));
                    pessels.add(pesel);
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
        StringBuilder data = new StringBuilder("");
        String filePath = scanner.nextLine();
        Saver fileSaver = new Saver(filePath);

        List<Long> validPessels = pessels.stream()
                .filter(pesel -> pesel.isValid(pesel.getDigits()))
                .map(PESEL::getPESEL)
                .collect(Collectors.toList());

        for(Long pesel: validPessels){
            data.append(pesel.toString()).append("\n");
        }
        fileSaver.Write(data.toString());

        // wypisz poprawne pesele
        System.out.println(messages.get("SavedMessage"));
        validPessels.stream()
                .forEach(System.out::println);

    }

    // metoda do wyłapywania niepoprawności we wpisywanych danych
    // wpisanie czegokolwiek innego niż cyfry nie wysypuje całego programu
    private static long getNumber(){
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
