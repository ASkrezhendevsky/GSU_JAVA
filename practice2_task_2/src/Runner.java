import by.gsu.pms.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Commodity commodity = new Commodity("Milk",new Byn(200));

        AbstractPurchase[] purchases = {
                new PercentDiscountPurchase(commodity, 1, 10),
                new PercentDiscountPurchase(commodity, 5, 20),
                new PriceDiscountPurchase(commodity, 3, new Byn(20)),
                new PriceDiscountPurchase(commodity, 8, new Byn(50)),
                new TransportExpensesPurchase(commodity, 12, new Byn(30)),
                new TransportExpensesPurchase(commodity, 2, new Byn(15)),
        };

        printPurchases(purchases);

        Arrays.sort(purchases);

        printPurchases(purchases);

        AbstractPurchase minCostPurchase = null;

        for (AbstractPurchase purchase: purchases) {
            if(minCostPurchase == null || minCostPurchase.getCost().compareTo(purchase.getCost()) > 0){
                minCostPurchase = purchase;
            }
        }

        System.out.println(minCostPurchase);
    }

    private static void printPurchases(AbstractPurchase[] purchases){
        for (AbstractPurchase purchase: purchases) {
            System.out.println(purchase);
        }
    }
}
