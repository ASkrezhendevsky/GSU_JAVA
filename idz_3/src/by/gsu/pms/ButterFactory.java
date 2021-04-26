package by.gsu.pms;

import by.gsu.pms.exceptions.CsvException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ButterFactory {
    public static Butter getButter(Scanner scanner) throws CsvException{
        try{
            return new Butter(scanner.next(), scanner.nextInt(), scanner.nextBoolean());
        }
        catch (InputMismatchException e){
            throw new CsvException();
        }
    }
}
