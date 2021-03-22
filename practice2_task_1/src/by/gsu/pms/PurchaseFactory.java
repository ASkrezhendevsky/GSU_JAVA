package by.gsu.pms;

import java.util.Scanner;

public class PurchaseFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE, BYN_DISCOUNT_PURCHASE, PERCENT_DISCOUNT_PURCHASE
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch (kind) {
            case GENERAL_PURCHASE:
                return new Purchase(sc);
            case BYN_DISCOUNT_PURCHASE:
                return new BynDiscountPurchase(sc);
            case PERCENT_DISCOUNT_PURCHASE:
                return new PercentDiscountPurchase(sc);
            default:
                throw new IllegalArgumentException();
        }
    }
}
