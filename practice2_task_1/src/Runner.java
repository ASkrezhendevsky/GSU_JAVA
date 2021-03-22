import by.gsu.pms.Purchase;
import by.gsu.pms.PurchaseFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileReader("src/in.txt"))){
            scanner.useLocale(Locale.ENGLISH);
            //task 1
            final int MAX_PURCHASES = 6;
            Purchase maxCostPurchase = new Purchase();
            Purchase[] purchases = new Purchase[MAX_PURCHASES];

            //task 2, 3, 4, 5
            boolean isAllEqual = true;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchaseFactory.getPurchaseFromFactory(scanner);
                System.out.println(purchases[i]);
                if (!purchases[i].equals(purchases[0])) {
                    isAllEqual = false;
                }

                if (maxCostPurchase.getCost() < purchases[i].getCost()) {
                    maxCostPurchase = purchases[i];
                }
            }

            if (isAllEqual) {
                System.out.println("All equal");
            } else {
                System.out.println("All not equal");
            }

            System.out.println("max cost purchase = " + maxCostPurchase);
        }
        catch (FileNotFoundException e){
            System.err.println("File not found");
        }
    }
}
