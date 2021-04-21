package by.gsu.pms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/in.txt";
        try (Scanner scanner = new Scanner(new FileReader(inputFile))){
            Paragraph paragraph = new Paragraph(scanner);
            System.out.println(paragraph.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
